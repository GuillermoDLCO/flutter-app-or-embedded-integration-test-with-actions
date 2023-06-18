import 'package:flutter/material.dart';
import 'package:flutter_integration_actions/pages/apps_screen.dart';
import 'package:flutter_integration_actions/pages/movies_screen.dart';

class HomeScreen extends StatelessWidget {
  const HomeScreen({Key? key}) : super(key: key);

  static const routeName = '/';

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Home Screen'),
      ),
      body: Column(
        children: [
          ElevatedButton(
            onPressed: () => Navigator.pushNamed(context, AppsScreen.routeName),
            child: const Text('Apps Screen'),
          ),
          ElevatedButton(
            onPressed: () =>
                Navigator.pushNamed(context, MoviesScreen.routeName),
            child: const Text('Movies Screen'),
          ),
        ],
      ),
    );
  }
}
