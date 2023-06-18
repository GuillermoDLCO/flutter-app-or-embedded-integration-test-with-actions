#!/bin/bash

flutter build apk --release
adb install build/app/outputs/flutter-apk/app-release.apk
maestro test ./integration_test/run-flow.yml