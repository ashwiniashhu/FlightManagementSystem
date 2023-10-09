import { TestBed } from '@angular/core/testing';

import { FlightCompanyService } from './flight-company.service';

describe('FlightCompanyService', () => {
  let service: FlightCompanyService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FlightCompanyService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
