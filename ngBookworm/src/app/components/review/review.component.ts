import { ReviewService } from './../../services/review.service';
import { Component, OnInit } from '@angular/core';
import { Review } from 'src/app/models/review';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css'],
})
export class ReviewComponent implements OnInit {
  reviews: Review[] = [];

  newReview: Review | null = null;

  displayReview: Review | null = null;
  editReview: Review | null = null;

  constructor(
    private reviewService: ReviewService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.reload();
    let id = Number(this.route.snapshot.paramMap.get('id'));
    if (id && !isNaN(id)) {
      this.show(id);
    }
  }

  display(review: Review) {
    this.displayReview = review;
    this.newReview = null;
    this.editReview = null;
  }

  initialize() {
    this.newReview = new Review();
  }

  reload() {
    this.reviewService.index().subscribe({
      next: (reviewList) => {
        this.reviews = reviewList;
      },
      error: (err) => {
        console.error(err);
      },
    });
  }

  show(id: number) {
    this.reviewService.show(id).subscribe({
      next: (review) => {
        this.displayReview = review;
      },
      error: (err) => {
        console.error(err);
      },
    });
  }

  create(review: Review) {
    this.reviewService.create(review).subscribe({
      next: (newReview: Review) => {
        this.reload();
        this.newReview = null;
      },
      error: (err: any) => {
        console.error(err);
      },
    });
  }

  update(review: Review) {
    this.reviewService.update(review).subscribe({
      next: (updateReview: Review) => {
        this.reload();
      },
      error: (err: any) => {
        console.error(err);
      }
    })
    this.editReview = null;
    this.displayReview = null;
  }


  destroy(id: number) {
    this.reviewService.destroy(id).subscribe({
      next:(value: void) => {
        this.reload();
        this.displayReview = null;
        this.editReview = null;
      },
      error: (err) => {
        console.error(err);
      }
    })
  }



}
