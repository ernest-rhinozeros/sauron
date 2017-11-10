import {Component} from '@angular/core';

type Container = 'container' | 'container-fluid';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  public container: Container = 'container';
}
