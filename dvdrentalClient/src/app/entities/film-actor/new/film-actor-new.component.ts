import { Component, OnInit, Inject } from '@angular/core';
import { ActivatedRoute,Router} from "@angular/router";
import { FormBuilder, Validators} from '@angular/forms';
import { MatDialogRef, MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';

import { FilmActorService } from '../film-actor.service';
import { IFilmActor } from '../ifilm-actor';
import { Globals, BaseNewComponent, PickerDialogService, ErrorService } from 'src/app/common/shared';
import { GlobalPermissionService } from 'src/app/core/global-permission.service';

import { ActorService } from 'src/app/entities/actor/actor.service';
import { FilmService } from 'src/app/entities/film/film.service';

@Component({
  selector: 'app-film-actor-new',
  templateUrl: './film-actor-new.component.html',
  styleUrls: ['./film-actor-new.component.scss']
})
export class FilmActorNewComponent extends BaseNewComponent<IFilmActor> implements OnInit {
  
    title:string = "New FilmActor";
	constructor(
		public formBuilder: FormBuilder,
		public router: Router,
		public route: ActivatedRoute,
		public dialog: MatDialog,
		public dialogRef: MatDialogRef<FilmActorNewComponent>,
		@Inject(MAT_DIALOG_DATA) public data: any,
		public global: Globals,
		public pickerDialogService: PickerDialogService,
		public filmActorService: FilmActorService,
		public errorService: ErrorService,
		public actorService: ActorService,
		public filmService: FilmService,
		public globalPermissionService: GlobalPermissionService,
	) {
		super(formBuilder, router, route, dialog, dialogRef, data, global, pickerDialogService, filmActorService, errorService);
	}
 
	ngOnInit() {
		this.entityName = 'FilmActor';
		this.setAssociations();
		super.ngOnInit();
    	this.setForm();
		this.checkPassedData();
		this.setPickerSearchListener();
    }
 		
	setForm(){
 		this.itemForm = this.formBuilder.group({
      actorId: ['', Validators.required],
      filmId: ['', Validators.required],
      actorDescriptiveField: [''],
      filmDescriptiveField: [''],
    });
    
    this.fields = [
		];
	}
	 
	setAssociations(){
  	
		this.associations = [
			{
				column: [
					{
						key: 'actorId',
						value: undefined,
						referencedkey: 'actorId'
					},
					  
				],
				isParent: false,
				table: 'actor',
				type: 'ManyToOne',
				service: this.actorService,
				label: 'actor',
				descriptiveField: 'actorDescriptiveField',
				referencedDescriptiveField: 'firstName',
		    
			},
			{
				column: [
					{
						key: 'filmId',
						value: undefined,
						referencedkey: 'filmId'
					},
					  
				],
				isParent: false,
				table: 'film',
				type: 'ManyToOne',
				service: this.filmService,
				label: 'film',
				descriptiveField: 'filmDescriptiveField',
				referencedDescriptiveField: 'title',
		    
			},
		];
		this.parentAssociations = this.associations.filter(association => {
			return (!association.isParent);
		});

	}
	
	onSubmit() {
		let filmActor = this.itemForm.getRawValue();
		super.onSubmit(filmActor);
		
	}
    
}
