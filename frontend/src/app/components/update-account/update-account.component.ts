import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Account } from '../../model/account';
import { AccountService } from '../../services/account.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-update-account',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './update-account.component.html',
  styleUrl: './update-account.component.css'
})
export class UpdateAccountComponent implements OnInit {
  id: string | null = "";
  account?: Account = new Account();
  message:string="";
  errorMessage:string="";

  constructor(private activatedRoute: ActivatedRoute, private accountService: AccountService) {
    this.id = this.activatedRoute.snapshot.paramMap.get('id');
    console.log(this.id);

  }
  ngOnInit(): void {
    this.accountService.getAccountById(this.id).subscribe(
      {
        next: (data) => {
          console.log(data);
          this.account=data;

        },
        error: (err) => {
          console.log(err);
          this.errorMessage = err.message;
          this.account=undefined;
        }
      }
    )
  }
  updateAccount(){
    console.log(this.account);
    this.accountService.updateAccount(this.account).subscribe(
      {
        next: (data) => {
          console.log(data);
         this.message="Account Updated.";

        },
        error: (err) => {
          console.log(err);
          if(err.name == "HttpErrorResponse")
          this.errorMessage =" Network error, please try again later."
          else
          this.errorMessage = err.error;
        }
      }
    )
  }
}
