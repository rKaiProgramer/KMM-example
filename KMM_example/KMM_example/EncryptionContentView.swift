import SwiftUI
import shared
struct EncryptionContentView: View {
    @State private var encryptResult = "Encryption Result"
    @State private var name = ""


    var body: some View {
        VStack(spacing: 20) {

            TextField("text to encode", text: $name).multilineTextAlignment(.center).font(.system(size: 30))
            HStack{
                Button(action: {
                    encryptResult = Encryption().encryptAes(data:name)
                }) {
                    Text("AES Encryption").font(.system(size: 30))
                }

            }
            Text(encryptResult).font(.system(size: 30))
            Spacer()

        }


    }

}
