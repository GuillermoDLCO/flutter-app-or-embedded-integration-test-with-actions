import 'package:flutter/material.dart';

class MoviesScreen extends StatelessWidget {
  const MoviesScreen({Key? key}) : super(key: key);

  static const routeName = '/movies';

  @override
  Widget build(BuildContext context) {
    return const Scaffold(
      body: Center(
        child: Column(
          children: [
            Text('Movies Screen'),
            Text('Movie 1'),
            Text('Movie 2'),
          ],
        ),
      ),
    );
  }
}
