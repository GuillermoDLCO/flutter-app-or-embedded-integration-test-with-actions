import 'package:flutter/material.dart';
import 'package:flutter_integration_actions/pages/apps_screen.dart';
import 'package:flutter_integration_actions/pages/home_screen.dart';
import 'package:flutter_integration_actions/pages/movies_screen.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Mobile App',
      routes: {
        HomeScreen.routeName: (context) => const HomeScreen(),
        AppsScreen.routeName: (context) => const AppsScreen(),
        MoviesScreen.routeName: (context) => const MoviesScreen(),
      },
    );
  }
}
