import { Component } from '@angular/core';

import { Account } from '../../model/account';
import { AccountService } from '../../services/account.service';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
@Component({
  selector: 'app-display-accounts',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './display-accounts.component.html',
  styleUrl: './display-accounts.component.css'
})
export class DisplayAccountsComponent {

  accounts: Account[] = [];

  message: string = "";
  errorMessage: string = "";

  constructor(private accountService: AccountService, private router: Router) {
    this.accountService.getAllAccount().subscribe(
      {
        next: (data) => {
          console.log(data);
          this.accounts = data;
        },
        error: (err) => {
          console.log(err);
          this.errorMessage = "Could't Load Accounts";
          this.message = "";
        },
        complete: () => {
          console.log("Server completed sending data.");

        }
      }
    )
  }


  deleteAccountById(id?: number) {
    console.log("delete id:" + id);

    if (confirm("Do you want to Delete Account id:" + id))
      this.accountService.deleteAccountById(id).subscribe(
        {
          next: (resp) => {
            console.log(resp);
            // delete account with id in local array
            this.accounts = this.accounts.filter((a) => a.id != id);
            this.message = "Deleted Account with id:" + id;
            this.errorMessage = "";
          },
          error: (err) => {
            console.log(err);
            this.message = "";
            this.errorMessage = "Coule not Delete Account.";
          }
        }
      );
  }

  updateAccount(account: Account) {
    console.log(account);

    this.router.navigateByUrl("update-account/" + account.id);

  }
}
