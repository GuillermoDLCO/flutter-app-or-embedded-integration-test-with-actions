import 'package:flutter/material.dart';

class AppsScreen extends StatelessWidget {
  const AppsScreen({Key? key}) : super(key: key);

  static const routeName = '/apps';

  @override
  Widget build(BuildContext context) {
    return const Scaffold(
      body: Center(
        child: Column(
          children: [
            Text('Apps'),
            Text('Netflix'),
            Text('Disney+'),
          ],
        ),
      ),
    );
  }
}
