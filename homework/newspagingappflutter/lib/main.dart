import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:flutter_tts/flutter_tts.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Homework News Pagination App Flutter Version',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      home: const MyHomePage(title: 'News Pagination App (Flutter Version)'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  List<dynamic> articles = [];
  late FlutterTts flutterTts;
  late ScrollController _scrollController;
  int _pageNumber = 1;

  Future<void> fetchNews() async {
    try {
      String apiUrl =
          'https://newsapi.org/v2/everything?q=tesla&from=2024-03-25&sortBy=publishedAt&apiKey=65037d87299349b5bcf42e2611cbbbc4';

      final response = await http.get(Uri.parse(apiUrl));
      if (response.statusCode == 200) {
        final jsonData = jsonDecode(response.body);
        setState(() {
          articles.addAll(jsonData['articles']);
        });
        _pageNumber++;
      } else {
        throw Exception('Failed to load news: ${response.statusCode}');
      }
    } catch (e) {
      print('Error fetching news: $e');
      // Handle error, e.g., display a message to the user
    }
  }

  @override
  void initState() {
    super.initState();
    fetchNews();
    flutterTts = FlutterTts();
    _scrollController = ScrollController();
    _scrollController.addListener(() {
      if (_scrollController.position.pixels ==
          _scrollController.position.maxScrollExtent) {
        fetchNews();
      }
    });
  }

  Future<void> speakArticle(String text) async {
    await flutterTts.setLanguage('en-US');
    await flutterTts.setPitch(1);
    await flutterTts.speak(text);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.blueGrey,
        title: Text(
          widget.title,
          style: const TextStyle(
              color: Colors.white, fontSize: 24),
        ),
      ),
      backgroundColor: Colors.black,
      body: ListView.builder(
        controller: _scrollController,
        itemCount: articles.length,
        itemBuilder: (context, index) {
          final article = articles[index];
          return Container(
            margin: const EdgeInsets.only(top: 20, right: 20, left: 20, bottom: 20),
            decoration: BoxDecoration(
              borderRadius: BorderRadius.circular(12),
              color: Color.fromARGB(255, 95, 95, 95),
              boxShadow: [
                BoxShadow(
                  color: Colors.grey.withOpacity(0.5),
                  spreadRadius: 1,
                  blurRadius: 5,
                  offset: const Offset(0, 3), 
                ),
              ],
            ),
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              // crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                const SizedBox(height: 12),
                Image.network(
                  article['urlToImage'] ?? '',
                  width: 200,
                  height: 150,
                ),
                const SizedBox(height: 12),
                Text(
                  article['title'] ?? '',
                  style: const TextStyle(
                    color: Colors.white,
                    fontWeight: FontWeight.bold, fontSize: 21
                  ),
                ),
                const SizedBox(height: 12),
                Text(
                  article['description'] ?? '',
                  style: const TextStyle(
                    color: Colors.white,
                    fontSize: 15
                  ),
                ),
                const SizedBox(height: 12),
                Row(
                  children: [
                    Text(
                      'Author: ${article['author'] ?? ''}',
                      style: const TextStyle(
                        color: Colors.white,
                        fontSize: 12
                      ),
                    ),
                    const SizedBox(width: 10),
                    Text(
                      'Published at: ${article['publishedAt'] ?? ''}',
                      style: const TextStyle(
                        color: Colors.white,
                        fontSize: 12
                      ),
                    ),
                  ],
                ),
                const SizedBox(height: 12),
              ],
            ),
          );
        },
),


    );
  }
}