import SwiftUI

struct ContentView: View {
    @State private var willMoveToNextScreen = false
    var body: some View {
        NavigationView {
            VStack(spacing: 20) {
                NavigationLink(destination: GreetingContentView()) {
                    Text("OS / Version").font(.system(size: 30))
                }
                NavigationLink(destination: EncryptionContentView()) {
                    Text("Encryption").font(.system(size: 30))
                }
                NavigationLink(destination: HanoiContentView()) {
                    Text("Hanoi Tower").font(.system(size: 30))
                }
                Spacer()
            }
        }
        
    }
}




struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        Group {
            ContentView()
        }
    }
}
