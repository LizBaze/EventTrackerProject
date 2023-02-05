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

  show(id: number): Observable<Review> {
    return this.http.get<Review>(this.url + '/' + id).pipe(
      catchError((err:any) => {
        console.error(err);
        return throwError(() => new Error('Error retrieving review ' + err));
      })
    )}

  create(review: Review): Observable<Review> {
    const httpOptions = {
      headers: {
        'Content-Type': 'application/json',
      },
    };

    return this.http.post<Review>(this.url, review, httpOptions).pipe(
      catchError((err:any) => {
        console.error(err);
        return throwError( () => new Error('ReviewService.create(): error creating review ' + err)
        );
      })
    );
  }


  update(review: Review) {
    const httpOptions = {
      headers: {
        'Content-Type': 'application/json',
      },
    };
    return this.http.put<Review>(this.url + '/' + review.id, review, httpOptions).pipe(
      catchError((err:any) => {
        console.error(err);
        return throwError( () => new Error('ReviewService.update(): Error updating review' + err)
        );
      })
    );
  }

  destroy(id: number) {
    return this.http.delete<void>(this.url + '/' + id);
  }



}
