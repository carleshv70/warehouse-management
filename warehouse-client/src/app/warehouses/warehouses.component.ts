import { Component, OnInit } from '@angular/core';
import { WarehouseDto } from '../dtos/warehouseDto'
import { WarehousesService } from '../services/warehouses.service';

@Component({
  selector: 'app-warehouses',
  templateUrl: './warehouses.component.html',
  styleUrls: ['./warehouses.component.css']
})
export class WarehousesComponent implements OnInit {

  private warehouses:WarehouseDto[] = []

  constructor(private service:WarehousesService) { }

  ngOnInit(): void {

    this.service.getWarehouses().subscribe( data => {
      this.warehouses = data;
    })
  }

  getWarehouses() :WarehouseDto[] {
    return this.warehouses;
  }


}
