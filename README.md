# Fresco
- 1 Fresco
- 2 ImageControll
 对u图片进行压缩，包括质量压缩和尺寸压缩，
 
 
 -- 关于图片
 1.文件形式(即以二进制形式存在于硬盘上)
2.流的形式(即以二进制形式存在于内存中)
3.Bitmap形式
这三种形式的区别: 文件形式和流的形式对图片体积大小并没有影响,也就是说,如果你手机SD卡上的如果是100K,那么通过流的形式读到内存中,也一定是占100K的内存,注意是流的形式,不是Bitmap的形式,当图片以Bitmap的形式存在时,其占用的内存会瞬间变大, 我试过500K文件形式的图片加载到内存,以Bitmap形式存在时,占用内存将近10M,当然这个增大的倍数并不是固定的

检测图片三种形式大小的方法:
文件形式: file.length()
流的形式: 讲图片文件读到内存输入流中,看它的byte数
Bitmap:    bitmap.getByteCount()
 
