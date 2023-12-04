import { Component, WritableSignal, signal } from '@angular/core';
import { ColumnDefinition } from '../../framework/controls/table/table.component';
import { EventList } from '../../model/event-list-interface';
import { ServiceLogService } from '../../services/service-log.service';
import { FrameworkModule } from '../../framework/framework.module';
import { HttpClientModule } from '@angular/common/http';

interface DetailedEventList {
  id: number;
  path: string;
  userName: number;
  date: string;
  time: string;
}

@Component({
  selector: 'character-event-list',
  standalone: true,
  imports: [FrameworkModule, HttpClientModule],
  templateUrl: './character-event-list.component.html',
  styleUrl: './character-event-list.component.scss'
})
export class CharacterEventListComponent {
  public columnDefinitions: Array<ColumnDefinition> = [];
  public eventList: WritableSignal<DetailedEventList[] | undefined> = signal(undefined);

  constructor(protected serviceLogService: ServiceLogService) {}

  ngOnInit(): void {
    this.columnDefinitions = [
      { attr: 'userName', label: 'User' },
      { attr: 'path', label: 'Service' },
      { attr: 'date', label: 'Date' },
      { attr: 'time', label: 'Time' },
    ];

    this.serviceLogService.getAll().subscribe((response: EventList[]) => {
      this.eventList.set(response.map((eventList: EventList) => {
        const { id, path, userName, dateTime } = eventList;
        const dateObject = new Date(dateTime);
        
        return <DetailedEventList>{
          id,
          path,
          userName,
          date: dateObject.toLocaleDateString(navigator.languages[0], { day: '2-digit', month: '2-digit', year: 'numeric'}),
          time: dateObject.toLocaleTimeString()
        }
      }));
    });
  }


}
