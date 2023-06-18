#!/bin/bash

adb uninstall com.android.app.example
adb install ./android_native_app/app/build/outputs/apk/release/app-release.apk
maestro test ./integration_test/run-flow.yml