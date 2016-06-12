#103060010 江秉翰 SoftwareStudio_HW8 
This assignmet is based on lab10 with little changes. 

The server part is as similar as the resorces(SocketSample) on iLms, which I add a JFrame to show it in a identical window, and change its output to the result after calculating.

On the client part, I mocked SocketSample to add some codes to make it able to connect to server. Before Page 1, user need to enter server's IP. After user click operation botton(+, -, *, /), app will connect to server and give it the answer, and server will show it on JFrame.

The hardest part is to get familiar with the code on Android, as a result, I reviewed SocketSample for so many times. Moreover, I forget to add uses-permission android:name="android.permission.INTERNET"/ in AndroidManifest.xml, which make my client & server unable to connect.
