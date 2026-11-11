import React from 'react';
import { StyleSheet, Text, View } from 'react-native';

export default function App() {
 return (
 <View style={styles.container}>

  <View style={styles.card}>

    <Text style={styles.name}>
      Maria Tai
    </Text>

    <Text style={styles.studentId}>
      Student ID: 101563558
    </Text>

  </View>

 </View>
 );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#E8F1F8',
    justifyContent: 'center',
    alignItems: 'center',
    padding: 20,
  },
  name: {
    fontSize: 32,
    fontWeight: 'bold',
    color: '#1D3557',
  },
  studentId: {
    fontSize: 20,
    color: '#457B9D',
    marginTop: 15,
  },
  card: {
    width: '85%',
    padding: 25,
    backgroundColor: 'white',
    borderRadius: 15,
    alignItems: 'center',
  },
})