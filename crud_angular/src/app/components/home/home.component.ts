import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { DatiService } from 'src/app/dati.service';
import { Serie } from 'src/app/serie';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  title = 'crud';
  shows$?: Observable<Serie[]>;
  isAdd: boolean = false;
  serie?: Serie = new Serie();
  isShown = true;
  generi = ["Animazione", "Drammatico", "Thriller"];
  constructor(public datiService: DatiService, private route: ActivatedRoute) {
    this.shows$ = this.datiService.getAll()
  }

  search: String ="";

  filter(value) {
    let filters = Array.from(document.querySelectorAll('#category'));
    for (let test of filters) {
      if (value == 99) {
        test.classList.value = "hidden";
        test.classList.value = "";
      }
      else {
        if (value == filters.indexOf(test)) {
          test.classList.value = "hidden";
          test.classList.value = "";
        }
        else {
          test.classList.value = "hidden";
        }
      }
    }
  }
}

