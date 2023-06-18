#!/bin/bash

rm -f pubspec.yaml
cp pubspec_app.yaml pubspec.yaml

flutter clean
flutter pub get

