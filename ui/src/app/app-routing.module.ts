import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {HomeComponent} from './component/private/home/home.component';
import {LoginComponent} from './component/public/login/login.component';
import {RegisterComponent} from './component/public/register/register.component';

import {AuthGuard} from './service/private/auth-guard';

export const routes: Routes = [
  {
    path: '',
    pathMatch: 'prefix',
    redirectTo: 'login',
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'register',
    component: RegisterComponent,
  },
  {
    path: '',
    children: [
      {
        path: 'home',
        canActivate: [AuthGuard],
        canActivateChild: [AuthGuard],
        component: HomeComponent,
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule],
})
export class AppRoutingModule {
}
