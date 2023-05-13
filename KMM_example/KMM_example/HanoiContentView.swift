import SwiftUI
import shared
struct HanoiContentView: View {
    @State private var step:Int32 = 0
    @State private var diskNum:Int = 10
    @State private var selectedDiskNum:Int = 10
    var hanoi = Hanoi(diskNum:Int32(10))


    var body: some View {

        let diskDistribution = hanoi.getDiskDistribution(step:step)

        VStack{
            Picker("", selection: $selectedDiskNum) {
                ForEach(1...10, id: \.self) {
                    Text("\($0) disks").font(.system(size: 30))
                }
            }.onChange(of: selectedDiskNum) { _ in
                self.step = 0
                self.diskNum = selectedDiskNum
                hanoi.setDiskNum(diskNum:Int32(diskNum))
            }.frame(width: 50)

            HStack(spacing: 10) {
                Button(action: {
                    if(self.step>0){
                        self.step -= 1
                    }
                }) {
                    if(self.step>0){
                        Text("previous step").font(.system(size: 30))
                    }else {
                        Text("previous step").font(.system(size: 30))
.disabled(true)
                    }

                }

                Text("\(step) / \(hanoi.getTotalStepNum())").font(.system(size: 30))


                Button(action: {
                    if(self.step<hanoi.getTotalStepNum()){
                        self.step += 1
                    }
                }) {
                    if(self.step<hanoi.getTotalStepNum()){
                        Text("next step").font(.system(size: 30))
                    }else {
                        Text("next step").font(.system(size: 30)).disabled(true)
                    }
                }


            }
            HStack(spacing: 0) {
                ZStack{
                    RodView()
                    VStack(spacing: 3) {
                        Spacer()
                        let arr = diskDistribution.get(index: 0)
                        ForEach((0 ..< arr!.count).reversed(), id: \.self) { i in
                            DiskView(arr![i] as! Int,diskNum)
                        }
                    }.padding([.bottom], 13)
                }
                ZStack{
                    RodView()
                    VStack(spacing: 3) {
                        Spacer()
                        let arr = diskDistribution.get(index: 1)
                        ForEach((0 ..< arr!.count).reversed(), id: \.self) { i in
                            DiskView(arr![i] as! Int,diskNum)
                        }
                    }.padding([.bottom], 13)
                }
                ZStack{
                    RodView()
                    VStack(spacing: 3) {
                        Spacer()
                        let arr = diskDistribution.get(index: 2)

                        ForEach((0 ..< arr!.count).reversed(), id: \.self) { i in
                            DiskView(arr![i] as! Int,diskNum)
                        }
                    }.padding([.bottom], 13)

                }
            }
        }
    }


}
// disk
struct DiskView: View {
    var viewNo: Int
    var diskNum: Int
    init(_ viewNo: Int,_ diskNum:Int) {
        self.viewNo = viewNo
        self.diskNum = diskNum
    }
    var body: some View {
        Rectangle()
            .fill(Color.blue)
            .frame(width: (CGFloat)(120 * (diskNum-viewNo)/diskNum), height: 15)
    }
}

// rod to put Disk
struct RodView: View {
    var body: some View {
        VStack(spacing: 0) {
            Spacer()

            Rectangle()
                .fill(Color.gray)
                .frame(width: 10, height: 185)

            Rectangle()
                .fill(Color.gray)
                .frame(width: 150, height: 13)
        }
    }
}



struct HanoiContentView_Previews: PreviewProvider {
    static var previews: some View {
        HanoiContentView()
    }
}
