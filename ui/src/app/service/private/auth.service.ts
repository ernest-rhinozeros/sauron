import {Injectable} from '@angular/core';
import {BehaviorSubject} from 'rxjs/Rx';
import {Router} from '@angular/router';

@Injectable()
export class AuthService {

  private $isLoggedIn: BehaviorSubject<boolean> = new BehaviorSubject(false);

  constructor(private router: Router) {
  }

  get isLoggedIn() {
    return this.$isLoggedIn.getValue();
  }

  set isLoggedIn(value: boolean) {
    this.$isLoggedIn.next(value);
    this.router.navigate(['/home']);
  }
}
