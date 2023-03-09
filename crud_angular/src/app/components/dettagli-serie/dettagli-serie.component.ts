import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { DatiService } from 'src/app/dati.service';
import { Serie } from 'src/app/serie';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-dettagli-serie',
  templateUrl: './dettagli-serie.component.html',
  styleUrls: ['./dettagli-serie.component.css']
})
export class DettagliSerieComponent implements OnInit {
  public href: string = "";
  shows$?: Observable<Serie[]>;
  constructor(public datiService: DatiService, private route: ActivatedRoute, private router: Router) {
    this.shows$ = this.datiService.getAll()
  }

  ngOnInit(): void {
    this.href = (this.router.url).slice(7);
    console.log(this.href);
  }
}
