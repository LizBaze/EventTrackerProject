import { ReviewService } from './../../services/review.service';
import { Component, OnInit } from '@angular/core';
import { Review } from 'src/app/models/review';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {

  reviews: Review[] = [];

  constructor(private reviewService: ReviewService) {}

  ngOnInit() {
    this.reload();
  }

  reload() {
    this.reviewService.index().subscribe( {
      next: (reviewList) => {
        this.reviews = reviewList;
      },
      error: (err) => {
        console.error(err);
      }
    })
  }







}
