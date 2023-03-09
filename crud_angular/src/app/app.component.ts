
import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { DatiService } from './dati.service';
import { Serie } from './serie';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'crud';
  shows$?: Observable<Serie[]>;
  isAdd: boolean = false;
  serie?: Serie = new Serie();
  isShown = true;
  generi = ["Animazione", "Drammatico", "Thriller"];
  constructor(public datiService: DatiService) {
    this.shows$ = this.datiService.getAll()
  }
  search: String ="";
  add() {
    this.isAdd = !this.isAdd;
  }
  canc(id: number) {
    this.datiService.canc(id).subscribe(res => {

      console.log(res);
      this.shows$ = this.datiService.getAll()

    });
  }

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

  update(serie: Serie) {
    this.serie = serie;
    this.add();
  }

  onFatto(fatto: boolean) {
    this.add();
    this.serie = new Serie();
    if (fatto)
      this.shows$ = this.datiService.getAll()
  }

  navigate(){
    this.isShown = false;
    let home = document.getElementById("home");
    home.classList.value="hidden";

  }
}

