import { HttpClient } from '@angular/common/http';
import { Component, ElementRef, OnInit, Renderer2 } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable, Subscription } from 'rxjs';
import { SpotifywebService } from 'src/app/spotifyweb.service';

@Component({
  selector: 'app-playlist',
  templateUrl: './playlist.component.html',
  styleUrls: ['./playlist.component.scss']
})
export class PlaylistComponent implements OnInit {
  comments:any
  selectedImage: any;
  inputText: string = '';
  Commentobj;
  dataArray;
  idSong;
  uri;
  idplaylist;
  constructor(private el: ElementRef,private renderer: Renderer2,private spotify: SpotifywebService,private route: ActivatedRoute,private router: Router,private http: HttpClient) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.idplaylist=id
     console.log(id );

    this.getData2(id)
    // this.spotify.changePlaylistDetails("6c4WI0Ogg5RTl0S3BTa3OV", "Earphoria", true, "Just Listen.").subscribe(data => {
    // });
  }

  fetchData(id:any): Observable<any> {
    const url = 'http://localhost:8081/api/comments/by-post/'+id;

    // Make the GET request
    return this.http.get(url);
  }

  
  write(e:any){
    console.log(this.inputText)
  }
  getData2(t:any) {
    this.spotify.getCategoryPlaylist(t).subscribe(data => {
      this.dataArray = data["playlists"].items;
      console.log(data)
      console.log(this.dataArray);
      console.log(this.dataArray[0].external_urls.spotify);
    });
    this.fetchData(t).subscribe(data => {
      this.comments = data;

    });
  }
  gotoSongs(a:any,image: any){
    this.selectedImage = image;
    this.idSong=a
    console.log(a)


  }
  onInputChange(value: string) {
    console.log('Input changed:', value);
    // Do something with the changed value
    const obj={
      "text":value,
      "postid":this.idplaylist,
      "userid":"malekd700@gmail.com"
  }
  this.Commentobj=obj
  }
  addtomyplaylist() {
    
    this.spotify.followPlaylist(this.idSong).subscribe(data => {
     
    });  }
  navigate(){
    this.router.navigate(['dashboard/songs/'+this.idSong]);

  }
  addcomment() {
    const data = { key: 'value' }; // Replace with your actual data

    this.http.post('http://localhost:8081/api/comments', this.Commentobj)
      .subscribe(response => {
        console.log('POST request was successful', response);
        this.showNotification('Comment published successfully', 'success');
        this.getData2(this.idplaylist)

        // Handle the response as needed
      }, error => {
        console.error('Error during POST request', error);
        // Handle errors
      });
  }
  private showNotification(message: string, type: 'success' | 'error') {
    const toast = this.renderer.createElement('div');
    this.renderer.addClass(toast, `toast-${type}`);
    const text = this.renderer.createText(message);
    this.renderer.appendChild(toast, text);
    this.renderer.appendChild(this.el.nativeElement, toast);

    setTimeout(() => {
      this.renderer.removeChild(this.el.nativeElement, toast);
    }, 3000); // Adjust the timeout as needed
  }
 
}
