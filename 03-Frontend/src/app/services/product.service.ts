import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../common/product';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators'; // rxjs is reactive javascript
import { ProductCategory } from '../common/product-category';


@Injectable({
  providedIn: 'root'
})

export class ProductService {
 
  private baseUrl = 'http://localhost:8080/api/products';
  private categoryUrl= 'http://localhost:8080/api/product-category';
  constructor(private httpClient: HttpClient) { } //Inject Http Client here

  getProductList(theCategoryId: number): Observable<Product[]> {
    // need to build URL based on category id 
    const searchUrl = `${this.baseUrl}/search/findByCategoryId?id=${theCategoryId}`;

    //Returns an observable
    return this.httpClient.get<GetResponseProducts>(searchUrl).pipe(
      map(response => response._embedded.products)
      //Map the JSON data from Spring Data REST to Product array
    );
  }

  getProductCategories(): Observable<ProductCategory[]>{
    return this.httpClient.get<GetResponseProductCategory>(this.categoryUrl).pipe(
      map(response => response._embedded.productCategory)
    );
  }


}

interface GetResponseProducts {  
//Unwraps the JSON from Spring Data Rest _embedded entry
  _embedded: {
    products: Product[];
  }
}

interface GetResponseProductCategory {  
  //Unwraps the JSON from Spring Data Rest _embedded entry
    _embedded: {
      productCategory: ProductCategory[];
    }
  }