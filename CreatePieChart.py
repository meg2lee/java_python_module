import pandas as pd
import matplotlib.pyplot as plt
import sys

def pieChart(imgfilename):
	sizes=[15,40,30,20]
	explode=(0,0.1,0,0)
	figl,axl=plt.subplots()
	axl.pie(sizes,explode=explode,autopct='%1.1f%%',shadow=True,startangle=90)
	axl.axis('equal')

	plt.savefig(imgfilename)
	plt.close()
	print("파이차트 완료")

def main(argv):
	print("argv : " + argv[2])
	pieChart(argv[2])

if __name__=='__main__':
	main(sys.argv)
