import {Component, OnInit} from '@angular/core';
import WaveSurfer from 'wavesurfer.js';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  ngOnInit() {
    var wavesurfer = WaveSurfer.create({
      container: '#waveform',
      waveColor: 'violet',
      progressColor: 'purple'
    });

    wavesurfer.load('https://srv-file2.gofile.io/download/jKE1Xq/test.flac');

    wavesurfer.on('ready', function () {
      wavesurfer.play();
    });
  }
}
