import {Injectable} from "@angular/core";
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Zulieferer} from "./zulieferer";

@Injectable({providedIn: 'root'})

export class ZuliefererServices {

  private apiServerUrl = environment.API_BASEURL

  constructor(private http: HttpClient) {
  }


  //Get all Zulieferer
  public getAll(): Observable<Zulieferer[]> {
    console.log('getZulieferer' + this.apiServerUrl + 'zulieferer')
    return this.http.get<Zulieferer[]>(`${this.apiServerUrl}/zulieferer/all`)
  }

  // Create a new Zuliefer
  public createZulieferer(zulieferer: Zulieferer): Observable<Zulieferer> {
    const headers ={'content-type':'application '}
    const body = JSON.stringify(zulieferer);
    console.log(body)
    return this.http.post<Zulieferer>(`${this.apiServerUrl}/zulieferer/add`, zulieferer)
  }

  // Updating an Existing Zuliefer
  public updateZulieferer(zulieferer: Zulieferer): Observable<Zulieferer> {
    return this.http.put<Zulieferer>(`${this.apiServerUrl}/zulieferer/update/`, zulieferer)
  }

  //Find Zulieferer By Id
  public getZuliefererById(zulieferId: number): Observable<Zulieferer[]> {
    return this.http.get<Zulieferer[]>(`${this.apiServerUrl}/zulieferer/find/${zulieferId}`)
  }


  //Delete an Zuliefer
  public deleteZulieferer(zuliefererId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/zulieferer/delete/${zuliefererId}`)
  }
}
