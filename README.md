# Tutorial APAP
## Authors
* **Najla Laila Muharram** - *1906399612* - *C*

---
## Tutorial 1
### What I have learned today
Saya belajar kembali mengenai penggunaan framework springboot.

### Github
**1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?**
Issue Tracker merupakan tracking tools yang yang terintegrasi dengan repositori GitHub. 
Issue Tracker ini mendokumentasikan issue yang ada pada proyek kita secara terurut waktu. 
Hal ini memudahkan proses tracking terhadap proyek-proyek yang  sedang berjalan. 
Issue Tracker juga mengakomodasikan fitur mention. Saat kita melakukan mention issue pada issue 
lain atau pada saat pull request maka otomatis akan muncul di timeline issue yang dimention. 
Dengan ini  maka kita dapat dengan mudah melihat keterkaitannya. Maka Issue Tracker merupakan 
cara yang bagus untuk melacak tasks, enhancements, and bugs pada proyek.

**2. Apa perbedaan dari git merge dan git merge --squash?**
Keduanya memiliki tujuan yaitu untuk menggabungkan commit-commit dari branch. Untuk Git merge squash melakukan penggabungan di Git yang akan menghasilkan commit gabungan dengan hanya satu parents. File digabungkan sama seperti halnya Git merge biasa  tetapi metadata commit diubah untuk menampilkan hanya satu commit parents. 


**3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan
suatu aplikasi?**
Dengan menggunakan VCS maka pengguna dapat mengembalikan berkas-berkas pekerjaan ke keadaan sebelumnya. Selain itu, dengan VCS pengguna dapat membandingkan suatu perubahan dengan perubahan-perubahan sebelumnya setiap waktu. Pada VCS juga pengguna dapat melihat siapa yang terakhir melakukan pengubahan terhadap sesuatu yang mungkin menimbulkan masalah. Selain itu, VCS juga memungkinkan developer untuk memiliki branch kode yang independent dan massive. Membuat, menghapus dan menggabungkan branch tersebut menjadi lebih cepat, lancar dan tidak butuh waktu yang lama.

### Spring
**4. Apa itu library & dependency?**
Library merupakan bagian tertentu dari perangkat lunak yang dapat dikonsumsi oleh program lain. Sedangkan dependency merupakan hubungan antara dua bagian kode. Seperti contohnya kode pertama memanggil kode kedua untuk melakukan tindakan atau mengembalikan beberapa informasi itu merupakan suatu bentuk dari dependency. Hubungan keduanya seperti hubungan orang dan kerabat.

**5. Apa itu Maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?**
Maven merupakan perangkat lunak manajemen proyek dan alat pemahaman. Berdasarkan konsep model objek proyek (POM), Maven dapat mengelola pembuatan, pelaporan, dan dokumentasi proyek dari informasi utama. Maven dikembangkan oleh Apache Software Foundation dan tipe lisensinya adalah free software license.
Maven ditulis dalam bahasa pemrograman Java dan pada awal masa pembuatannya dikenal sebagai Jakarta Project. Maven adalah tool yang menemani programmer
dari awal hingga akhir proses pengembangan. Hal ini dikarenakan Maven sangat berguna bagi programmer Java di dalam proses pengembangan aplikasi mulai dari pembuatan project, mereferensi external library (file-file JAR), pembuatan dokumentasi hingga compiling dan pembuatan application package (misalnya JAR atau WAR). Alasan kita menggunakan maven yaitu karena maven mempermudah pengerjaan. Alternatif lain selain Maven ada Gradle, Eclipse, dan Apache Ant.

**6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring
framework?**
Spring framework dapat digunakan untuk mengembangkan aplikasi java lainnya baik mobile app, web app, dan desktop apps.

**7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya
menggunakan @RequestParam atau @PathVariable?**
 Perbedaan paling penting dari @RequestParam dan @PathVariable terletak dari cara mengekstrak value. @PathVariable digunakan untuk mengakses nilai dari template URI. Sedangkan @RequestParam digunakan untuk mengakses nilai dari parameter query.

### What I did not understand
- [ ] Kenapa saya harus belajar APAP?
- [ ] Penggunaan @RequestParam @PathVariable
- [ ] Tidak mengerti package yang diimport di controller

## Tutorial 2

**Pertanyaan 1: Cobalah untuk menambahkan sebuah Bioskop dengan mengakses link berikut: http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20PAPA%20APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx&jumlahStudio=10 Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi**

Terjadi error Whitelabel Error Page dengan status 500 karena belum ada template yang dituju yaitu add-bioskop.html
![](https://i.ibb.co/bX3SVJW/image.png)

**Pertanyaan 2: Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat**

Anotasi @Autowired pada kelas Controller adalah implementasi dari konsep depedency injection. Dengan menggunakan 
@Autowired memungkinkan kita memasukkan depedensi objek secara implisit, sehingga tidak perlu membuat
setter, getter, atau constructor.

**Pertanyaan 3: Cobalah untuk menambahkan sebuah Bioskop dengan mengakses link berikut: http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20PAPA%20 APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.**
Terjadi error Whitelabel Error Page dengan status 400 karena link yang dimasukkan tidak lengkap. Alamat tersebut tidak mencantumkan jumlahStudio. 
![](https://i.ibb.co/JFK2m7v/image.png)

**Pertanyaan 4: Jika Papa APAP ingin melihat Bioskop dengan nama Bioskop Maung, link apa yang harus diakses?**

Pertama saya melakukan add bioskop maung dengan idBioskop 4:
http://localhost:8080/bioskop/add?idBioskop=4&namaBioskop=Bioskop%20MAUNG&alamat=Maung%20Fasilkom&noTelepon=081xxx&jumlahStudio=10
![](https://i.ibb.co/02czvtX/image.png)
Setelah itu saya mengakses http://localhost:8080/bioskop/view?idBioskop=4 untuk menampilkan detail dari Bioskop Maung 
![](https://i.ibb.co/R0GVrWP/image.png)


**Pertanyaan 5: Tambahkan 1 contoh Bioskop lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/bioskop/viewall , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.**

Saya menambahkan Bioskop XXXI dengan id 8 
Setelah melakukan view all melalui http://localhost:8080/bioskop/viewall berikut merupakan tampilan yang muncul. Terdapat Bioskop dengan id 1, bioskop dengan id 4, dan bioskop dengan id 8.
![](https://i.ibb.co/ZfYbpkz/tut2apap.jpg)
![](https://i.ibb.co/fMj2Zwz/tut2apaplagi.jpg)





