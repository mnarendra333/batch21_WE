import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }


  list = [

    {

        stuId : 101,
        stuName : 'ravi',
        marks : 5000

    },
    {

      stuId : 102,
      stuName : 'kumar',
      marks : 5000

  },
  {

    stuId : 103,
    stuName : 'raja',
    marks : 5000

}


  ]

}
