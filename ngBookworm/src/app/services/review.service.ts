import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { environment } from 'src/environments/environment.development';
import { Review } from '../models/review';

@Injectable({
  providedIn: 'root',
})
export class ReviewService {
  url = environment.baseUrl + 'api/reviews';

  constructor(private http: HttpClient) {}

  index(): Observable<Review[]> {
    return this.http.get<Review[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () =>
            new Error('TodoService.index(): error retrieving review list: ' + err)
        );
      })
    );
  }







}
