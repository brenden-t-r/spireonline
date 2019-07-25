import {Component, OnInit} from '@angular/core';
//import { WaveformPlaylist } from 'waveform-playlist';
//import { WaveformPlaylist } from '@node/waveform-playlist';

//var WaveformPlaylist = require('waveform-playlist');

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  project: any;

  ngOnInit() {
    this.project = JSON.parse(this.json);
    console.log(this.project);
    this.createMultitrackPlayer();
  }

  private createMultitrackPlayer() {
    const WaveformPlaylist = require('waveform-playlist');

    var playlist = WaveformPlaylist.init({
      // samplesPerPixel: 10000,
      sampleRate: 48000,
      container: document.getElementById('playlist'),
      state: 'cursor',
      controls: {
        show: true,
        width: 200
      },
      // zoomLevels: [3000, 5000, 10000, 20000]
    });



    let tracks = [];
    let longestTrackLength = 0;
    for (let track of this.project['tracks']) {
      console.log(track);

      for (let clip of track['clips']) {
        tracks.push({
          src: 'http://localhost:4200/assets/CoyoteSpire/' + clip['file_name'],
          name: clip['id'],
          start: clip['start_frame_in_timeline']/48000,
          muted: track['mute'],
          // gain: track['gain'] / 10,
        })
      }

      // tracks.push({
      //   src: 'http://localhost:4200/assets/CoyoteSpire/' + clip['file_name'],
      //   name: clip['id'],
      //   start: clip['start_frame_in_timeline']/48000,
      //   //gain: track['gain'],
      // })
    }

    playlist.load(tracks).then(function() {
      // can do stuff with the playlist.
    });

    const ee = playlist.getEventEmitter();

    setTimeout(() => {
      //ee.emit('play');
    }, 3000);


  }


  json = "{\n" +
    "  \"name\" : \"Coyote jan\",\n" +
    "  \"modified\" : \"2019-03-03T19:16:19Z\",\n" +
    "  \"time_signature\" : {\n" +
    "    \"beats\" : 4,\n" +
    "    \"divisions\" : 4\n" +
    "  },\n" +
    "  \"id\" : \"3593DEA3-C69A-4311-83B3-5353AE5F681A\",\n" +
    "  \"created\" : \"2019-01-06T03:33:37Z\",\n" +
    "  \"tempo\" : 120,\n" +
    "  \"project_file_version\" : 1,\n" +
    "  \"dirty\" : false,\n" +
    "  \"tracks\" : [\n" +
    "    {\n" +
    "      \"clips\" : [\n" +
    "        {\n" +
    "          \"file_duration_frames\" : 11097344,\n" +
    "          \"sample_rate\" : 48000,\n" +
    "          \"end_frame_in_file\" : 11097344,\n" +
    "          \"start_frame_in_timeline\" : 0,\n" +
    "          \"id\" : \"34BC5F6B-C77E-4286-A1A4-FC8A533FBD50\",\n" +
    "          \"file_name\" : \"5B3F7CD1-F5C5-4C74-BD47-A89D2559C7B4.flac\",\n" +
    "          \"start_frame_in_file\" : 0\n" +
    "        }\n" +
    "      ],\n" +
    "      \"stereoize\" : true,\n" +
    "      \"id\" : \"4AF2F01F-86AB-470A-A3D9-12F50C74605F\",\n" +
    "      \"mute\" : false,\n" +
    "      \"pan\" : -0.029556632041931152,\n" +
    "      \"color_index\" : 0,\n" +
    "      \"gain\" : 6\n" +
    "    },\n" +
    "    {\n" +
    "      \"clips\" : [\n" +
    "        {\n" +
    "          \"file_duration_frames\" : 2903296,\n" +
    "          \"sample_rate\" : 48000,\n" +
    "          \"end_frame_in_file\" : 2565264,\n" +
    "          \"start_frame_in_timeline\" : 146627,\n" +
    "          \"id\" : \"CF7B11A0-9A04-498A-B989-854A66652F20\",\n" +
    "          \"file_name\" : \"15D2E752-B416-48A0-A004-D012E2382C01.flac\",\n" +
    "          \"start_frame_in_file\" : 0\n" +
    "        },\n" +
    "        {\n" +
    "          \"file_duration_frames\" : 1740032,\n" +
    "          \"sample_rate\" : 48000,\n" +
    "          \"end_frame_in_file\" : 1740032,\n" +
    "          \"start_frame_in_timeline\" : 2711891,\n" +
    "          \"id\" : \"2A3AF340-FE8A-4E0E-A2A5-2066FDF80318\",\n" +
    "          \"file_name\" : \"DA6EB4E0-4D2F-4A5F-B08C-2DA8230188B4.flac\",\n" +
    "          \"start_frame_in_file\" : 0\n" +
    "        },\n" +
    "        {\n" +
    "          \"file_duration_frames\" : 1722368,\n" +
    "          \"sample_rate\" : 48000,\n" +
    "          \"end_frame_in_file\" : 1722368,\n" +
    "          \"start_frame_in_timeline\" : 5637879,\n" +
    "          \"id\" : \"56C5D30C-58A5-4590-B899-29213C850AB9\",\n" +
    "          \"file_name\" : \"DF1E146D-040E-4731-B4DA-FE230DBEEDDC.flac\",\n" +
    "          \"start_frame_in_file\" : 0\n" +
    "        }\n" +
    "      ],\n" +
    "      \"stereoize\" : true,\n" +
    "      \"id\" : \"027243E6-A3BA-4FF2-B9D2-DE004CF61F7C\",\n" +
    "      \"mute\" : false,\n" +
    "      \"pan\" : -0.049261152744293213,\n" +
    "      \"color_index\" : 1,\n" +
    "      \"gain\" : 5.7443556785583496\n" +
    "    },\n" +
    "    {\n" +
    "      \"clips\" : [\n" +
    "        {\n" +
    "          \"file_duration_frames\" : 1687296,\n" +
    "          \"sample_rate\" : 48000,\n" +
    "          \"end_frame_in_file\" : 1687296,\n" +
    "          \"start_frame_in_timeline\" : 2765415,\n" +
    "          \"id\" : \"1C6C779B-B2F3-470E-A64A-F6132E9AE1F5\",\n" +
    "          \"file_name\" : \"55603159-C8C8-4D26-ABD6-BF96AE3EC47B.flac\",\n" +
    "          \"start_frame_in_file\" : 0\n" +
    "        },\n" +
    "        {\n" +
    "          \"file_duration_frames\" : 1794304,\n" +
    "          \"sample_rate\" : 48000,\n" +
    "          \"end_frame_in_file\" : 1794304,\n" +
    "          \"start_frame_in_timeline\" : 5584355,\n" +
    "          \"id\" : \"24FEBAAC-C835-4134-87CD-A4E177C8F832\",\n" +
    "          \"file_name\" : \"42695148-8FE6-4BB5-B76D-11FAF60BA344.flac\",\n" +
    "          \"start_frame_in_file\" : 0\n" +
    "        }\n" +
    "      ],\n" +
    "      \"stereoize\" : true,\n" +
    "      \"id\" : \"FB5C8279-6C50-4E5A-9340-6235638CE87B\",\n" +
    "      \"mute\" : false,\n" +
    "      \"pan\" : 0.014778375625610352,\n" +
    "      \"color_index\" : 2,\n" +
    "      \"gain\" : 4.1568241119384766\n" +
    "    },\n" +
    "    {\n" +
    "      \"clips\" : [\n" +
    "        {\n" +
    "          \"file_duration_frames\" : 1118464,\n" +
    "          \"sample_rate\" : 48000,\n" +
    "          \"end_frame_in_file\" : 1118464,\n" +
    "          \"start_frame_in_timeline\" : 4870699,\n" +
    "          \"id\" : \"3D6E2EC2-8B12-4F3D-AA3F-86BEECC39B45\",\n" +
    "          \"file_name\" : \"BA1D248D-0245-455E-83B6-266B67D62485.flac\",\n" +
    "          \"start_frame_in_file\" : 0\n" +
    "        },\n" +
    "        {\n" +
    "          \"file_duration_frames\" : 1008384,\n" +
    "          \"sample_rate\" : 48000,\n" +
    "          \"end_frame_in_file\" : 1008384,\n" +
    "          \"start_frame_in_timeline\" : 10169592,\n" +
    "          \"id\" : \"E0A1C13A-7DBB-4267-81F9-5A729C5D281B\",\n" +
    "          \"file_name\" : \"AC18BF1B-189E-43E0-AC6C-E3DDC21FA6F9.flac\",\n" +
    "          \"start_frame_in_file\" : 0\n" +
    "        },\n" +
    "        {\n" +
    "          \"file_duration_frames\" : 1377280,\n" +
    "          \"sample_rate\" : 48000,\n" +
    "          \"end_frame_in_file\" : 1377280,\n" +
    "          \"start_frame_in_timeline\" : 1510224,\n" +
    "          \"id\" : \"CF836D5A-ACBC-4AFD-827F-EE2E412F3E9B\",\n" +
    "          \"file_name\" : \"B7A6924B-7E60-4B59-A9AD-BE89EF6AC874.flac\",\n" +
    "          \"start_frame_in_file\" : 0\n" +
    "        }\n" +
    "      ],\n" +
    "      \"stereoize\" : true,\n" +
    "      \"id\" : \"F5070EBD-94F5-4CCC-9DA4-FAE11C11C195\",\n" +
    "      \"mute\" : true,\n" +
    "      \"pan\" : -0.019704461097717285,\n" +
    "      \"color_index\" : 3,\n" +
    "      \"gain\" : 5.0341434478759766\n" +
    "    },\n" +
    "    {\n" +
    "      \"clips\" : [\n" +
    "        {\n" +
    "          \"file_duration_frames\" : 1647872,\n" +
    "          \"sample_rate\" : 48000,\n" +
    "          \"end_frame_in_file\" : 1647872,\n" +
    "          \"start_frame_in_timeline\" : 2731181,\n" +
    "          \"id\" : \"20F5DB18-1C97-4837-9B3D-A8FEE3887B2C\",\n" +
    "          \"file_name\" : \"22894D7D-23EA-447A-9215-07B6F55C4ECD.flac\",\n" +
    "          \"start_frame_in_file\" : 0\n" +
    "        },\n" +
    "        {\n" +
    "          \"file_duration_frames\" : 1503744,\n" +
    "          \"sample_rate\" : 48000,\n" +
    "          \"end_frame_in_file\" : 1503744,\n" +
    "          \"start_frame_in_timeline\" : 5816293,\n" +
    "          \"id\" : \"46F8EAB3-008B-4ED5-BF1F-FCDB0FED8C5C\",\n" +
    "          \"file_name\" : \"88307C51-3F41-43CA-B53B-B9AD040B8133.flac\",\n" +
    "          \"start_frame_in_file\" : 0\n" +
    "        },\n" +
    "        {\n" +
    "          \"file_duration_frames\" : 1166848,\n" +
    "          \"sample_rate\" : 48000,\n" +
    "          \"end_frame_in_file\" : 1166848,\n" +
    "          \"start_frame_in_timeline\" : 8831488,\n" +
    "          \"id\" : \"6FB98080-7FD3-43E5-A6C5-6C4413FF9EA2\",\n" +
    "          \"file_name\" : \"0A7B4898-4DAE-405D-8B6E-A1F62DABD4B2.flac\",\n" +
    "          \"start_frame_in_file\" : 0\n" +
    "        }\n" +
    "      ],\n" +
    "      \"stereoize\" : true,\n" +
    "      \"id\" : \"3ED00B28-73FC-44B4-A18C-D3669E0DBBB7\",\n" +
    "      \"mute\" : true,\n" +
    "      \"pan\" : 0,\n" +
    "      \"color_index\" : 4,\n" +
    "      \"gain\" : 0\n" +
    "    },\n" +
    "    {\n" +
    "      \"clips\" : [\n" +
    "        {\n" +
    "          \"file_duration_frames\" : 1469952,\n" +
    "          \"sample_rate\" : 48000,\n" +
    "          \"end_frame_in_file\" : 1469952,\n" +
    "          \"start_frame_in_timeline\" : 2943829,\n" +
    "          \"id\" : \"2B5C9C9B-780D-4A66-BB32-378B21A41C03\",\n" +
    "          \"file_name\" : \"320F64B7-F40E-490D-B685-ADADAADD1D17.flac\",\n" +
    "          \"start_frame_in_file\" : 0\n" +
    "        },\n" +
    "        {\n" +
    "          \"file_duration_frames\" : 1510912,\n" +
    "          \"sample_rate\" : 48000,\n" +
    "          \"end_frame_in_file\" : 1510912,\n" +
    "          \"start_frame_in_timeline\" : 5780610,\n" +
    "          \"id\" : \"1F017561-DCF4-4EBD-9F03-907E8C88B887\",\n" +
    "          \"file_name\" : \"D6CB4AB1-82F6-4E83-8B54-43E0BAA29849.flac\",\n" +
    "          \"start_frame_in_file\" : 0\n" +
    "        },\n" +
    "        {\n" +
    "          \"file_duration_frames\" : 1228032,\n" +
    "          \"sample_rate\" : 48000,\n" +
    "          \"end_frame_in_file\" : 1228032,\n" +
    "          \"start_frame_in_timeline\" : 8890078,\n" +
    "          \"id\" : \"16973766-6338-4637-BBA4-73E7EA8543F1\",\n" +
    "          \"file_name\" : \"1A9E7DD9-AB17-4B6B-B8AA-279D441A5A51.flac\",\n" +
    "          \"start_frame_in_file\" : 0\n" +
    "        }\n" +
    "      ],\n" +
    "      \"stereoize\" : true,\n" +
    "      \"id\" : \"E380463D-CCA0-41B0-92D3-CCA113B9FAC1\",\n" +
    "      \"mute\" : false,\n" +
    "      \"pan\" : 0,\n" +
    "      \"color_index\" : 5,\n" +
    "      \"gain\" : 0\n" +
    "    },\n" +
    "    {\n" +
    "      \"clips\" : [\n" +
    "        {\n" +
    "          \"file_duration_frames\" : 872960,\n" +
    "          \"sample_rate\" : 48000,\n" +
    "          \"end_frame_in_file\" : 872960,\n" +
    "          \"start_frame_in_timeline\" : 4442506,\n" +
    "          \"id\" : \"EFF371C0-2610-4AF7-BF82-64A2BB9F0A5F\",\n" +
    "          \"file_name\" : \"556FE719-1BEE-4C1B-B073-B25714AC6F98.flac\",\n" +
    "          \"start_frame_in_file\" : 0\n" +
    "        },\n" +
    "        {\n" +
    "          \"file_duration_frames\" : 1473792,\n" +
    "          \"sample_rate\" : 48000,\n" +
    "          \"end_frame_in_file\" : 1473792,\n" +
    "          \"start_frame_in_timeline\" : 8849329,\n" +
    "          \"id\" : \"07771019-51C6-437D-ADAA-19819A16BE90\",\n" +
    "          \"file_name\" : \"E1937ACE-6DE6-40CC-BA6E-BD66C0EDB312.flac\",\n" +
    "          \"start_frame_in_file\" : 0\n" +
    "        },\n" +
    "        {\n" +
    "          \"file_duration_frames\" : 306944,\n" +
    "          \"sample_rate\" : 48000,\n" +
    "          \"end_frame_in_file\" : 306944,\n" +
    "          \"start_frame_in_timeline\" : 2237681,\n" +
    "          \"id\" : \"1B23D960-1BE5-496D-B42A-A1E013715DE5\",\n" +
    "          \"file_name\" : \"CCAA2B89-1414-4DAE-BF8F-5D5EA1E26E0D.flac\",\n" +
    "          \"start_frame_in_file\" : 45216\n" +
    "        },\n" +
    "        {\n" +
    "          \"file_duration_frames\" : 823040,\n" +
    "          \"sample_rate\" : 48000,\n" +
    "          \"end_frame_in_file\" : 823040,\n" +
    "          \"start_frame_in_timeline\" : 1414641,\n" +
    "          \"id\" : \"5B6B2C22-895F-4DA1-9C29-64D872339367\",\n" +
    "          \"file_name\" : \"DC5754BD-80F3-4407-8048-10C408B6DD58.flac\",\n" +
    "          \"start_frame_in_file\" : 0\n" +
    "        },\n" +
    "        {\n" +
    "          \"file_duration_frames\" : 420864,\n" +
    "          \"sample_rate\" : 48000,\n" +
    "          \"end_frame_in_file\" : 420864,\n" +
    "          \"start_frame_in_timeline\" : 2664700,\n" +
    "          \"id\" : \"02E94F60-4AC2-44AF-812E-5544E0FA783E\",\n" +
    "          \"file_name\" : \"78C694E7-141C-40A0-BC16-07032378C38A.flac\",\n" +
    "          \"start_frame_in_file\" : 0\n" +
    "        }\n" +
    "      ],\n" +
    "      \"stereoize\" : true,\n" +
    "      \"id\" : \"7A345ACB-3FFE-478E-ACAF-849F264441CE\",\n" +
    "      \"mute\" : true,\n" +
    "      \"pan\" : 0,\n" +
    "      \"color_index\" : 6,\n" +
    "      \"gain\" : 0\n" +
    "    },\n" +
    "    {\n" +
    "      \"clips\" : [\n" +
    "        {\n" +
    "          \"file_duration_frames\" : 1829888,\n" +
    "          \"sample_rate\" : 48000,\n" +
    "          \"end_frame_in_file\" : 1829888,\n" +
    "          \"start_frame_in_timeline\" : 8795805,\n" +
    "          \"id\" : \"7A64ABDB-413C-47E0-9EC2-36550E2586BF\",\n" +
    "          \"file_name\" : \"47283756-5B84-4B4D-9039-663AF2B75DBC.flac\",\n" +
    "          \"start_frame_in_file\" : 0\n" +
    "        },\n" +
    "        {\n" +
    "          \"file_duration_frames\" : 1915392,\n" +
    "          \"sample_rate\" : 48000,\n" +
    "          \"end_frame_in_file\" : 1854815,\n" +
    "          \"start_frame_in_timeline\" : 1025138,\n" +
    "          \"id\" : \"5BA81372-3CE6-4A09-8134-8A93AFB9C2B4\",\n" +
    "          \"file_name\" : \"AC4251CA-B385-456A-942E-216646CFBD3C.flac\",\n" +
    "          \"start_frame_in_file\" : 0\n" +
    "        },\n" +
    "        {\n" +
    "          \"file_duration_frames\" : 165376,\n" +
    "          \"sample_rate\" : 48000,\n" +
    "          \"end_frame_in_file\" : 165376,\n" +
    "          \"start_frame_in_timeline\" : 2879953,\n" +
    "          \"id\" : \"CB7936B0-E736-4371-BC05-10D1DAEFC1E4\",\n" +
    "          \"file_name\" : \"80EC1BB5-38D1-4386-92CB-16184D41FBDE.flac\",\n" +
    "          \"start_frame_in_file\" : 0\n" +
    "        }\n" +
    "      ],\n" +
    "      \"stereoize\" : true,\n" +
    "      \"id\" : \"5364FF7E-7BBD-40D9-8E56-9F216F226C9C\",\n" +
    "      \"mute\" : false,\n" +
    "      \"pan\" : 0,\n" +
    "      \"color_index\" : 7,\n" +
    "      \"gain\" : 0\n" +
    "    }\n" +
    "  ],\n" +
    "  \"num_tracks\" : 8,\n" +
    "  \"duration\" : 232.87450000000001,\n" +
    "  \"metronome_on\" : false\n" +
    "}";
}
