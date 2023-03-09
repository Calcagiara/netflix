import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

import { DatiService } from '../dati.service';
import { Serie } from '../serie';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  @Input() serie:Serie= new Serie();
  @Output() fatto =new EventEmitter<boolean>();

  seriefrm:FormGroup;

  constructor(public datiService:DatiService, public fb: FormBuilder) { 
    this.seriefrm=fb.group(new Serie());
  }

  ngOnInit(): void {
    console.log(this.serie)
    this.seriefrm= this.fb.group({
      id: [this.serie.id],
      'titolo':new FormControl(this.serie.titolo,[ Validators.required, Validators.minLength(4)]),
      'cover':new FormControl(this.serie.cover,[ Validators.required]),
      'genere':new FormControl([this.serie.genere])
    });
  }

  onSubmit(serie:Serie){
    if (this.serie.id!=0) // 
      this.datiService.update(serie).subscribe(res => 
        {
          this.fatto.emit(true);
         }//,
        // err =>{
        //   // gestione errore
        // }
        )
    else this.datiService.add(serie).subscribe(res => 
      {
        this.fatto.emit(true);
      })
  }

  annulla(){
    this.fatto.emit(false);
  }
}
