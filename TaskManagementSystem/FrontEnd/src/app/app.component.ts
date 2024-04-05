import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'UserManagement';

  baseUrl="http://localhost:8080/"
  students:any;

  constructor(public http:HttpClient){}

  userid:number=0;
  username:string="";
  password:string="";

  login(){
    let obj=[this.username, this.password];
    let url=this.baseUrl+'login';
    this.http.post(url,obj).subscribe((data:any)=>{
      if(data==null || data==0){
        window.alert("Something went wrong");
      }
      else{
        this.userid=data;
      }
    });
  }

  logout(){
    this.userid=0;
    this.tasks=[];
  }

  tasks:any;
  
  readall(){
    let url=this.baseUrl+'readAllTasks'+this.userid;
    this.http.get(url).subscribe((data:any)=>{
      console.log(data);
      this.tasks=data;
     },
     (error)=>{
      console.error("Error fetching task:", error);
     });
  }

  details:string='';

  add(){
    let url=this.baseUrl+'add'+this.userid;
    this.http.post(url,this.details).subscribe((data:any)=>{
      this.tasks.push(data);
      console.log(data);
      this.details="";
    });
  }

  delete(){
    let url=this.baseUrl+'delete'+this.userid;
    this.http.post(url,this.details).subscribe((data:any)=>{
      this.tasks.splice(data);
      window.alert('Done');
    });
  }
}
