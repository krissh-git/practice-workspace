import { TestBed, inject } from '@angular/core/testing';

import { StackServiceService } from './stack-service.service';

describe('StackServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [StackServiceService]
    });
  });

  it('should be created', inject([StackServiceService], (service: StackServiceService) => {
    expect(service).toBeTruthy();
  }));
});
