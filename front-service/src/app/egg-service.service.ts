import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import * as http from "http";


@Injectable({
  providedIn: 'root'
})
export class EggServiceService {

  constructor(private httpClient: HttpClient) { }

  public test() {
    return this.httpClient.get('http://localhost:8081/eggs');
  }
}
