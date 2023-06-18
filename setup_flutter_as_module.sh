#!/bin/bash

rm -f pubspec.yaml
cp pubspec_module.yaml pubspec.yaml

flutter clean
flutter pub get

