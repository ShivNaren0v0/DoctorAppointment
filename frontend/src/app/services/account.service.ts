import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Account } from '../model/account';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private httpClient: HttpClient) { }
  getAllAccount(): Observable<any> {
    return this.httpClient.get('http://localhost:8090/accounts');
  }

  addNewAccount(newAccount: Account): Observable<any> {
    return this.httpClient.post("http://localhost:8090/account", newAccount);
  }
  deleteAccountById(id?: number): Observable<any> {
    //if(id !=undefined)
    return this.httpClient.delete("http://localhost:8090/account/" + id);
  }
  updateAccount(account?: Account): Observable<any> {
    return this.httpClient.put("http://localhost:8090/account", account);
  }
  getAccountById(id?: string | null): Observable<any> {
    return this.httpClient.get("http://localhost:8090/account/" + id);
  }
}
