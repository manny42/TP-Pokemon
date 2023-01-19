import { TestBed } from '@angular/core/testing';

import { EggServiceService } from './egg-service.service';

describe('EggServiceService', () => {
  let service: EggServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EggServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
