import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { WarehouseDto } from '../dtos/warehouseDto';
import { Observable } from 'rxjs';
import { map, tap } from 'rxjs/operators';

interface WarehouseData {
  id:number;
	uuid:string; 
	client:string; 
	family:string; 
	size:number; 
}


@Injectable({
  providedIn: 'root'
})
export class WarehousesService {

  private urlBase = "http://localhost:8080/";

  constructor(private http: HttpClient) { }

  getWarehouses(): Observable<WarehouseDto[]> {

    const url = "http://localhost:8080/warehouses/";

    return this.http.get<WarehouseData[]>(this.urlBase + 'warehouses/')
      .pipe(
        map( resp => resp.map(warehouse => this.mapToDto(warehouse))),
        tap( response => {

          console.log("response:", response);
        })
      )
  }

  private mapToDto(entity:WarehouseData):WarehouseDto {

    return new  WarehouseDto(entity.id, entity.uuid, entity.client, entity.family, entity.size);
  }
}
