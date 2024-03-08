import { Routes } from '@angular/router';
import { AddaAccountComponent } from './components/adda-account/adda-account.component';
import { C1Component } from './components/c1/c1.component';
import { C2Component } from './components/c2/c2.component';
import { DemoComponent } from './components/demo/demo.component';
import { DetailsComponent } from './components/details/details.component';
import { DisplayAccountsComponent } from './components/display-accounts/display-accounts.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { NeedsLoginComponent } from './components/needs-login/needs-login.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { ProductsComponent } from './components/products/products.component';

import { RegisterComponent } from './components/register/register.component';
import { UpdateAccountComponent } from './components/update-account/update-account.component';
import { adminGuard } from './guards/admin.guard';
import { authGuard } from './guards/auth.guard';

export const routes: Routes = [
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'demo', component: DemoComponent,canActivate:[authGuard] },
    { path: 'home', component: HomeComponent },
    {path:'products',component:ProductsComponent},
    {path:'details/:id',component:DetailsComponent},
    {path:'accounts',component:DisplayAccountsComponent},
    {path:'account',component:AddaAccountComponent,canActivate:[adminGuard]},    
    {path:'update-account/:id',component:UpdateAccountComponent},    
    {path:'needs-login',component:NeedsLoginComponent},  
    {path:'c1',component:C1Component},
    {path:'c2',component:C2Component},
    { path: '', redirectTo: 'home', pathMatch:'full' },
    { path: '**', component: PageNotFoundComponent }
];
