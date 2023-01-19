import { Component } from '@angular/core';
import {EggServiceService} from "./egg-service.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'test-app';

  constructor(public eggService: EggServiceService) {
    const obs = this.eggService.test();
    obs.subscribe(el => {
      console.log(el);
    });
}
}
