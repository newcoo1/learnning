(MAINLOOP)
    @SCREEN
    D=A
    @drawadd
    M=D		//drawadd is pointer to screen mem map
    @clearadd
    M=D
       @KBD
    D=M
    @CLEARLOOP 
    D;JLE
    @R1
    M=D

    (DRAWLOOP)
	@SCREEN
	D=A
	@8000
	D=D+A
	@drawadd
	D=M-D
	@MAINLOOP
	D;JGT
	@drawadd
	A=M
	M=-1
	@1
	D=A
	@drawadd
	M=M+D	
	
	@DRAWLOOP
	0;JMP
 (CLEARLOOP)
	@SCREEN
	D=A
	@8000
	D=D+A
	@clearadd
	D=M-D
	@MAINLOOP
	D;JGT
	@clearadd
	A=M
	M=0
	@1
	D=A
	@clearadd
	M=M+D
	@CLEARLOOP
	0;JMP


