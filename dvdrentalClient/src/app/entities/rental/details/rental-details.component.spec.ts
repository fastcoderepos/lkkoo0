import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { of } from 'rxjs';
import { NO_ERRORS_SCHEMA } from '@angular/core';
import { Router } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { Location } from '@angular/common';

import { TestingModule, EntryComponents } from 'src/testing/utils';
import { IRental, RentalService, RentalDetailsComponent, RentalListComponent } from '../';
import { DateUtils } from 'src/app/common/shared';
import { ListComponent, DetailsComponent, FieldsComp } from 'src/app/common/general-components';

describe('RentalDetailsComponent', () => {
  let component: RentalDetailsComponent;
  let fixture: ComponentFixture<RentalDetailsComponent>;
  let el: HTMLElement;
  
  let d = new Date();
  let t = DateUtils.formatDateStringToAMPM(d);
  
  let relationData: any = {
    customerId: 1,
    customerDescriptiveField: 'firstName1',
    inventoryId: 1,
    inventoryDescriptiveField: 1,
    staffId: 1,
    staffDescriptiveField: 'firstName1',
  }
  let data:IRental = {
    rentalDate: d,
    rentalId: 1,
    returnDate: d,
    ... relationData
  };
  
  describe('Unit Tests', () => {
    beforeEach(async(() => {
      TestBed.configureTestingModule({
        declarations: [
          RentalDetailsComponent,
          DetailsComponent
        ],
        imports: [TestingModule],
        providers: [
          RentalService,
        ],
        schemas: [NO_ERRORS_SCHEMA]  
      }).compileComponents();
    }));
  
    beforeEach(() => {
      fixture = TestBed.createComponent(RentalDetailsComponent);
      component = fixture.componentInstance;
      fixture.detectChanges();
    });

    it('should create', () => {
      expect(component).toBeTruthy();
    });

    it('should run #ngOnInit()', async () => {
      spyOn(component.dataService, 'getById').and.returnValue(of(data));
      component.ngOnInit();

      expect(component.item).toEqual(data);
      expect(component.itemForm.getRawValue()).toEqual(data);
      component.itemForm.enable();
      expect(component.itemForm.valid).toEqual(true);
      expect(component.title.length).toBeGreaterThan(0);
      expect(component.associations).toBeDefined();
      expect(component.childAssociations).toBeDefined();
      expect(component.parentAssociations).toBeDefined();
    });

    it('should run #onSubmit()', async () => {
      component.item = data;
      component.itemForm.patchValue(data);
      component.itemForm.enable();
      fixture.detectChanges();

      spyOn(component, 'onSubmit').and.returnValue();
      el = fixture.debugElement.query(By.css('button[name=save]')).nativeElement;
      el.click();

      expect(component.onSubmit).toHaveBeenCalled();
    });

    it('should call the back', async () => {
      component.item = data;
      fixture.detectChanges();

      spyOn(component, 'onBack').and.returnValue();
      el = fixture.debugElement.query(By.css('button[name=back]')).nativeElement;
      el.click();
      
      expect(component.onBack).toHaveBeenCalled();
    });

  });
  
  describe('Integration Tests', () => {
    beforeEach(async(() => {

      TestBed.configureTestingModule({
        declarations: [
          RentalDetailsComponent,
          RentalListComponent,
          DetailsComponent,
          ListComponent,
          FieldsComp
        ].concat(EntryComponents),
        imports: [
          TestingModule,
          RouterTestingModule.withRoutes([
            { path: 'rental', component: RentalDetailsComponent },
            { path: 'rental/:id', component: RentalListComponent }
          ])
        ],
        providers: [
          RentalService
        ]

      }).compileComponents();
    }));

    beforeEach(() => {
      fixture = TestBed.createComponent(RentalDetailsComponent);
      component = fixture.componentInstance;
      fixture.detectChanges();
    });

    it('should create', () => {
      expect(component).toBeTruthy();
    });

    it('should run #ngOnInit()', async () => {
      spyOn(component.dataService, 'getById').and.returnValue(of(data));

      component.ngOnInit();

      expect(component.item).toEqual(data);
      expect(component.itemForm.getRawValue()).toEqual(data);
      component.itemForm.enable();
      expect(component.itemForm.valid).toEqual(true);
      expect(component.title.length).toBeGreaterThan(0);
      expect(component.associations).toBeDefined();
      expect(component.childAssociations).toBeDefined();
      expect(component.parentAssociations).toBeDefined();
    });

    it('should update the record and notify the user', async () => {
      spyOn(component.errorService, 'showError').and.returnValue();

      component.item = data;
      component.itemForm.patchValue(data);
      component.itemForm.enable();
      fixture.detectChanges();

      spyOn(component.dataService, 'update').and.returnValue(of(data));
      el = fixture.debugElement.query(By.css('button[name=save]')).nativeElement;
      el.click();

      expect(component.errorService.showError).toHaveBeenCalled();

    });

    it('should go back to list component when back button is clicked', async () => {
      const router = TestBed.get(Router);
      const location = TestBed.get(Location);
      let navigationSpy = spyOn(router, 'navigateByUrl').and.callThrough();

      component.item = data;
      fixture.detectChanges();
      el = fixture.debugElement.query(By.css('button[name=back]')).nativeElement;
      el.click();

      let responsePromise = navigationSpy.calls.mostRecent().returnValue;
      await responsePromise;
      expect(location.path()).toBe('/rental');

    });

  });
  
});
