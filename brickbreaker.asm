.model small 
.stack 1024 
.data 

	menu 	  	db 10,"    " ,219,219,219,219,219, "              " ,219, "                                                   "  
				db 10,"    " ,219, "   " ,219, "              " ,219, " " ,219, "    " ,219,219,219,219,219, "  " ,219,219,219,219,219, "  " ,219,219,219,219,219, "     " ,219, "    " ,219, "  " ,219, " " ,219,219,219,219,219, " " ,219,219,219,219,219
				db 10,"    " ,219,219,219,219,219, "  " ,219,219,219, " " ,219, "  " ,219
				db 219,219, "  " ,219,219, "     " ,219, "   " ,219, "  " ,219, "   " ,219, "  " ,219, "        " ,219, " " ,219, "   " ,219, " " ,219, "  " ,219, "     " ,219, "   " ,219
				db 10,"    " ,219, "   " ,219, "  " ,219, "   " ,219, "  " ,219, "    " ,219, " " ,219, "    " ,219,219,219
				db 219,219, "  " ,219,219,219,219,219, "  " ,219,219,219,219,219, "   " ,219,219,219,219,219, "  " ,219,219, "   " ,219,219,219,219,219, " " ,219,219,219,219,219
				db 10,"    " ,219,219,219,219,219, "  " ,219, "   " ,219, "  " ,219,219,219, "  " ,219, "   " ,219, "  " ,219, "   " ,219, "  " ,219, "  " ,219, "   " ,219, "      " ,219, "     " ,219, " " ,219, " " ,219, "  " ,219, "     " ,219, "  " ,219, " "
				db 10,"                              " ,219,219,219,219,219, "  " ,219, "   " ,219, "  " ,219,219,219,219,219, "  " ,219, "     " ,219, " " ,219, "  " ,219, " " ,219,219,219,219,219, " " ,219, "   " ,219
				db 10," "
				db 10," "
				db 10,"                                 [1] EASY"				
				db 10,"                                 [2] MEDIUM"					
				db 10,"                                 [3] HARD"		
				db 10,"                                 [4] INSTRUCTIONS"			
				db 10,"                                 [5] SCORES"					
				db 10,"                                 [6] QUIT"
				db 10," "
				db 10,"                                   Your choice: ","$"				
		
   instructions db 10,"    " ,219,219,219,219,219, "              " ,219, "                                                   "  
				db 10,"    " ,219, "   " ,219, "              " ,219, " " ,219, "    " ,219,219,219,219,219, "  " ,219,219,219,219,219, "  " ,219,219,219,219,219, "     " ,219, "    " ,219, "  " ,219, " " ,219,219,219,219,219, " " ,219,219,219,219,219
				db 10,"    " ,219,219,219,219,219, "  " ,219,219,219, " " ,219, "  " ,219
				db 219,219, "  " ,219,219, "     " ,219, "   " ,219, "  " ,219, "   " ,219, "  " ,219, "        " ,219, " " ,219, "   " ,219, " " ,219, "  " ,219, "     " ,219, "   " ,219
				db 10,"    " ,219, "   " ,219, "  " ,219, "   " ,219, "  " ,219, "    " ,219, " " ,219, "    " ,219,219,219
				db 219,219, "  " ,219,219,219,219,219, "  " ,219,219,219,219,219, "   " ,219,219,219,219,219, "  " ,219,219, "   " ,219,219,219,219,219, " " ,219,219,219,219,219
				db 10,"    " ,219,219,219,219,219, "  " ,219, "   " ,219, "  " ,219,219,219, "  " ,219, "   " ,219, "  " ,219, "   " ,219, "  " ,219, "  " ,219, "   " ,219, "      " ,219, "     " ,219, " " ,219, " " ,219, "  " ,219, "     " ,219, "  " ,219, " "
				db 10,"                              " ,219, 219 , 219 , 219 , 219 , "  " , 219 , "   " , 219 , "  " , 219 , 219 , 219 , 219 , 219 , "  " , 219 , "     " , 219 , " " , 219 , "  " , 219 , " " , 219 , 219 , 219 , 219 , 219 , " " , 219 , "   " , 219
				db 10," "
				db 10," "
				db 10,"    GOAL:   Break all the bricks with the bouncing ball by navigating the "
				db 10,"            buffle with the left and right arrow keys."
				db 10," "
				db 10," "
				db 10,"    POWER-UPS: The different colors of the bricks denote different power-ups."
				db 10,"               BLUE-slower"
				db 10,"               RED-faster"
				db 10,"               YELLOW-short buffle"
				db 10,13,"               LIGHT MAGENTA-long buffle $"

	choice   	db ?
	gameover 	db 10," "
			    db 10,"      ", 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177 
			    db 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177
			    db 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177
			    db 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177
			    db 10," ", 10
			    db 13,  10, "      ",219,219,219, 219, 219, 219, "     ",219, 219, "      ",219, "   ",219, "   ",219, 219, 219, 219, 219, "     ",219, 219, 219, 219, 219, "   ",219, "     ",219, "  ",219, 219, 219, 219, 219, "  ",219, 219, 219, 219, 219, " "
				db 13,  10, "      ",219,"        ", 219,219, "  ",219, "    ",219, " ",219, " ",219, " ",219, "  ",219, "         ",219, "   ",219, "   ",219, "     ",219, "  ",219, "      ",219, "    ",219
				db 13,  10, "      ",219," ", 219,219, 219, 219, "   ",219, 219, 219, 219, 219, 219, "   ",219, "  ",219, "  ",219, "  ",219, 219, 219, 219, "      ",219, "   ",219, "   ",219, "     ",219, "  ",219, 219, 219, 219, "   ",219, " ",219, 219, 219
				db 13,  10, "      ",219,"   ",219,219, "  ",219, "      ",219, "  ",219, "  ",219, "  ",219, "  ",219, "         ",219, "   ",219, "    ",219, "   ",219, "   ",219, "      ",219, "    ",219
				db 13,  10, "      ", 219, 219,219, 219, 219, 219, "  ",219, "      ",219, "  ",219, "  ",219, "  ",219, "  ",219, 219, 219, 219, 219, "     ",219, 219, 219, 219, 219, "      ",219, "     ",219, 219, 219, 219, 219, "  ",219, "    ",219, " $"
				

	return	 	db 13, 10, 10, 10, 10, 10, "Press Enter to return to MENU. $"
	congrats	db 13, 10, "                            Congratulations! You WIN! $"
			
	finalScore  db 13, 10, 10,10,"                                    Final Score: ","$"			
	row1 		db 5		; x position for video mode
	col1 		db 25		; y position for video mode			

   brick_block db 6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6		
			   db 6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6		
			   db 6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6			
			   db 6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6		
			   db 6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6		
			   db 6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6		
			   db 6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6			
			   db 6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6
			   db 6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6		  
			   db 6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6
			   db 6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6
			   db 6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6	
			   db 2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2		
			   db 2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2		
			   db 9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9	
			   db 9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9	
			   db 9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9	
			   db 9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9	
			   db 9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9	
			   db 9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9	
			   db 9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9	
			   db 9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9	
			   db 9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9	
			   db 9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,5,5,5,5,5,5,5,5,5,5,5,5
			   db 5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5
			   db 5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5

	bricks     db 		4, 12, 1, 9, 2, 10, 5, 13, 6, 14 
			   db 		4, 12, 1, 9, 2, 10, 5, 13, 6, 14 
			   db 		4, 12, 1, 9, 2, 10, 5, 13, 6, 14 
			   db 		4, 12, 1, 9, 2, 10, 5, 13, 6, 14 
			   db 		4, 12, 1, 9, 2, 10, 5, 13, 6, 14 
	x		   db ?
	y		   db ?
	ball1      db      15, 15, 15, 15         
	balplayGame_loop1   db      0 , 0 , 15, 15, 0 , 0 ,  0 , 15, 15, 15, 15, 0 , 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 0 , 15, 15, 15, 15, 0 , 0 , 0 , 15, 15, 0 , 0 
	ball3      db      0 , 0 , 0 , 0 , 15, 15, 0 , 0 , 0 , 0  
			   db      0 , 0 , 15, 15, 15, 15, 15, 15, 0 , 0  
			   db      0 , 15, 15, 15, 15, 15, 15, 15, 15, 0  
			   db      0 , 15, 15, 15, 15, 15, 15, 15, 15, 0 
			   db      15, 15, 15, 15, 15, 15, 15, 15, 15, 15 
			   db      15, 15, 15, 15, 15, 15, 15, 15, 15, 15 
			   db      0 , 15, 15, 15, 15, 15, 15, 15, 15, 0  
			   db      0 , 15, 15, 15, 15, 15, 15, 15, 15, 0  
			   db      0 , 0 , 15, 15, 15, 15, 15, 15, 0 , 0  
			   db      0 , 0 , 0 , 0 , 15, 15, 0 , 0 , 0 , 0 
	 
	balls      dw      ball1, balplayGame_loop1, ball3 	
	sizes      dw      2, 6, 10 
	 
	ball_x     dw      160 					;initial x position of the ball 
	ball_y     dw      170 					;initial  y position of the ball
	ball_r     dw      2 
	 
	step_x     dw      ? 		;to increase speed
	step_y     dw      ? 		;to increase speed
	 
	buffle     dw      180 		
	buf_len    dw      50		;length of buffle
	 
	delayTime  db      1

	counter    dw      50		;counter
	rand       db ? 
	max        db ?
	
	ones_score db ?  ;ones score
	hundreds_score db ?  ;hundreds score
	tens_score db ?  ;tens score
	Score      db 	"SCORE: ","$"
	score_num  db 0
	onesScore  db ?
	hundredsScore db ?
	tensScore  db ? 
	scoreNum   db 0

	addScore   db ?
	addScore1  db 1
	addScore2  db 2
	addScore3  db 3
  nameofPlayer db 10," "
			   db 10,"      ", 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177 
			   db 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177
			   db 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177
			   db 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177, 177
			   db 10," "
			   db 10, "                        NAME OF PLAYER (5 letters):  $"
			   
	name1      db ?       ;storage for 1st letter of name and so on until the fifth letter
	name2      db ?
	name3      db ?
	name4      db ?
	name5      db ?

	spaces	   db "          ",0
	fileName   db "scores.txt",0,8 ,'$'; name of file to use
   fileHandler dw ? 	; file handler
	BufferSeg  dw  0
	ErrMsgOpen db  "Error opening `"
	FileLength dw 0

	nextLine	db	13,10
	ctr         db 0
	temp        dw ?
	scores      db 13, 10, 10,"                                      SCORES                                      ",10,"$"
	errorf 	    db 13, 10, "error: input file not found.", "$"
	errorg   	db 13, 10, "error: some error encountered.", "$"

	infile    	db 		'scores.txt', 00h
	inhandle  	word	?
	outhandle 	word 	?
	newtext   	db	 	512	dup(?)
	bytesread 	word 	?
	temp2 		word 	?

.code  

displayFile proc  near
    mov     ax,cs
    mov     ds,ax
    mov     bx,ss
    add     bx,200h/10h     ;get past the end of the file
    mov     [BufferSeg],bx  ;store the buffer segment
    
	push    ds

    mov     ax,cs
    mov     ds,ax
    mov     ax,3d00h    ;open file (ah=3dh)
    mov     dx,offset FileName
    int     21h
    jc      openError
    mov     bx,ax       ;move the file handle into bx

    mov     ds,[BufferSeg]
    mov     dx,0            
    mov     ah,3fh
    mov     cx,0FFFFh       
    int     21h

    mov     [cs:FileLength],ax

    mov     ah,3eh
    int     21h             ;close file

    cld
    mov     si,0
    mov     cx,[cs:FileLength]
	
displayFile_print:
    mov     ah,2
    lodsb
    mov     dl,al
    int     21h         

    dec     cx
    jne     displayFile_print
    
    pop     ds
    ret

openError:
    mov     ah,9
    mov     dx,offset ErrMsgOpen
    int     21h

    pop     ds
    ret
 displayFile ENDP


drawBrick   proc    near 
    push    di 
    mov     ah, AL 
    mov     bx, 10			; space of bricks

	drawBrick_loop1: 
        dec     bx 
        mov     cx, 15				; to draw rectangle
        rep     stosw 				;store string word
        stosb 	
        add     di, 320 - 31 			;to draw rectangle
        test    bx, bx 
        jnz     drawBrick_loop1 
        pop     di 
        ret 
drawBrick   endp 
 

drawBricks proc    near        ;complete drawing the bricks
    mov     si, offset bricks 
    xor     di, di 
    xor     dx, dx 
	
	drawBricks_loop1: 
        mov     al, [si] 
        call    drawBrick 
        add     di, 32 
        inc     si 
        inc     dx 
        cmp     dx, 10 
        jb      drawBricks_skip1 
        add     di, 320 * 11
        xor     dx, dx 
	drawBricks_skip1:      
        cmp     si, offset bricks + 50			; compare to how many bricks 
        jb      drawBricks_loop1 
        ret 
drawBricks endp 

drawBall    proc    near 
    push    bx 
    push    si 
    push    di 
    push    ax                      ;count position in screen memory 
 
	mov     ax, ball_y 
    mov     bx, 320			
    imul    bx 
    add     ax, ball_x 
    mov     di, ax 
 
	pop     ax 
 
    mov     bx, ball_r 
    mov     bx, sizes[bx] 
    mov     cx, bx                  ; cx = bx = counter 
 
    test    ax, ax 
    jz      drawBall_clear 
 
	mov     si, offset balls 		;string ball1, balplayGame_loop1, ball3
    add     si, ball_r 
    mov     si, [si] 

	drawBall_loop1:             
        push    cx 
 
        mov     cx, bx 
        rep     movsb 
        add     di, 320
        sub     di, bx 
 
        pop     cx 
        loop    drawBall_loop1 
 
        jmp     drawBall_exit 
		
	drawBall_clear: 
        xor     ax, ax 
		
	drawBall_loop2: 
        push    cx 
 
        mov     cx, bx 
        rep     stosb 
        add     di, 320 
        sub     di, bx 
 
        pop     cx 
        loop    drawBall_loop2
		
	drawBall_exit: 
        pop     di 		
        pop     si 
        pop     bx 
        ret 
drawBall    endp 
 
 
drawBuffle   proc    near 

    mov 	di, 320 * 180				; buffle position
	add     di, buffle 
    mov     ah, al
 
    mov     cx, buf_len 
    shr     cx, 1 
    rep     stosw 
 
    add     di, 640				; redraw buffle
    sub     di, buf_len 
 
    mov     cx, buf_len 
    shr     cx, 1 
    rep     stosw 
    ret 
drawBuffle   endp 

moveBall    proc    near  ;function to move the ball
    xor     ax, ax 
    call    drawBall 		;draw the ball
 
    mov     ax, ball_x 
    mov     bx, ball_y 
 
    add     ax, step_x 
    add     bx, step_y 
 
    mov     ball_x, ax 
    mov     ball_y, bx 
 
    mov     ax, 1 
    call    drawBall 
    ret 
moveBall    endp 

hitBrick  proc    near        ;function to check if ball hit brick
    mov     si, ball_r 
    mov     si, sizes[si] 
    shr     si, 1 
 
    mov     bx, ball_x         ;for up direction 
    add     bx, si 
    mov     ax, ball_y 
    dec     ax 
    call    getColor 
    mov     dh, dl 
    inc     bx 
    call    getColor 
    or      dl, dh 
    test    dl, dl 
    jnz     up_down 
 
    mov     bx, ball_x                  ; for down direction
    add     bx, si 
    mov     ax, ball_y 
    add     ax, si 
    add     ax, si 
    call    getColor 
    mov     dh, dl 
    inc     bx 
    call    getColor 
    or      dl, dh 
    test    dl, dl 
    jnz     up_down 
 
    mov     bx, ball_x                  ; for left direction
    dec     bx 
    mov     ax, ball_y 
    add     ax, si 
    call    getColor 
    mov     dh, dl 
    inc     ax 
    call    getColor 
    or      dl, dh 
    test    dl, dl 
    jnz     left_right 
 
    mov     bx, ball_x                  ; for right direction 
    add     bx, si 
    add     bx, si 
    mov     ax, ball_y 
    add     ax, si 
    call    getColor 
    mov     dh, dl 
    inc     ax 
    call    getColor 
    or      dl, dh 
    test    dl, dl 
    jnz     left_right 
    jmp     hitBrick_skip1 
	
	up_down: 
        neg     step_y 
        jmp     hit_brick 
		
	left_right: 
        neg     step_x 
		
	hit_brick: 
        cmp     dl, 14			;color hit by ball
        ja      @bridgeSkip
		
		cmp 	dl, 4
		je		@faster
		
		cmp 	dl, 1
		je		@slower
		
		cmp 	dl, 13
		je		@longerBuffle
		
		cmp		dl, 14
		je		@bridgeShorterBuffle
		
		cmp 	dl, 10
		je		@normal
		
		jmp 	@resume
		
		@bridgeSkip:
			jmp hitBrick_skip1
			
		@normal:
			mov temp, cx
			mov cx, 2
			mov step_x, cx
			mov cx, -2
			mov step_y, cx
			mov cx, 50
			mov buf_len, cx
			mov cx, temp
			mov temp, ax
			mov ax, 15
			call drawBuffle
			mov ax, temp
			jmp @resume
				
		@bridgeShorterBuffle:
			jmp @shorterBuffle
			
		@faster:
			mov temp, cx
			mov cx, 3
			mov step_x, cx
			mov cx, -3
			mov step_y, cx
			mov cx, temp		
			jmp @resume
		@slower:
			mov temp, cx
			mov cx, 1
			mov step_x, cx
			mov cx, -1
			mov step_y, cx
			mov cx, temp
			jmp @resume
		@longerBuffle:
			mov temp, cx
			mov cx, 100
			mov buf_len, cx
			mov cx, temp
			mov temp, ax
			mov ax, 15
			call drawBuffle
			mov ax, temp
			jmp @resume
		@shorterBuffle:
			mov temp, cx
			mov cx, 40
			mov buf_len, cx
			mov cx, temp
			mov temp, ax
			mov ax, 15
			call drawBuffle
			mov ax, temp
			jmp @resume
		
		@resume:
        dec     counter 
 
        push    ax              ; y = y - (y mod 12) 
        mov     cx, 12            
        xor     dx, dx 
        div     cx 
        pop     ax 
        sub     ax, dx 
        xchg    ax, bx          ; bx = new y, ax = x 
 
        push    ax              ; x = x - (x mod 32) 
        mov     cx, 32 
        xor     dx, dx 
        div     cx               
        pop     ax 
        sub     ax, dx 
        xchg    ax, bx          ; ax = new y, bx = new x 
 
        mov     cx, 320 
        mul     cx 
        add     ax, bx 
        mov     di, ax 
		
		inc 	ctr
        xor     ax, ax 
		mov 	al, addScore
		add 	score_num, al
		xor 	ax, ax
		call displayScore
		xor ax, ax
		xor bx, bx
        call    drawBrick 
		
	hitBrick_skip1: 
		
        ret 
hitBrick  endp 


hitWall proc    near       ;function to check if ball hits the wall
    mov     ax, ball_x 
    mov     bx, ball_y 
 
    mov     si, ball_r 
    mov     si, sizes[si] 
    mov     cx, 318 
    sub     cx, si 
 
    cmp     ax, cx 
    jg      x_wall 
    cmp     ax, 1 
    jl      x_wall 
 
    mov     cx, 200 
    sub     cx, si 
    cmp     bx, cx 
    jg      y_out 
    cmp     bx, 1 
    jl      y_wall 
    jmp     hitWall_skip1 
	
	x_wall: 
        neg     step_x 
        jmp     hit_wall 
	y_wall: 
        neg     step_y 
        jmp     hit_wall  
	y_out: 
        mov     ax, 2 
        ret 
	hit_wall: 
		
        mov     ax, 1 
        ret 
	hitWall_skip1: 
        xor     ax, ax 
        ret 
hitWall endp 
 

getColor   proc    near        ;function to get color of current position
    push    ax 
    push    cx 
    push    si 
 
    mov     cx, 320 
	mul     cx 
    add     ax, bx 
    mov     si, ax 
 
    mov     dl, byte ptr es:[si] 
         
    pop     si 
    pop     cx 
    pop     ax 
    ret 
getColor   endp 


delay   proc    near     ;delay time 
	delay_loop1: 
        push    cx 
        mov     cx, 0 
	delay_loop2: 
        loop    delay_loop2 
        pop     cx 
        loop    delay_loop1 
        ret 
delay   endp 

gotoxy proc near							;go to (x,y) positions
	mov ah, 2
	mov bh, 0
	mov dh, y			;y
	mov dl, x			;x
	int 10H
	
	mov ah, 9
	mov bl, 13
	xor bh,bh
	mov cx,1
	
	ret
gotoxy endp

menuDisplay proc far
    mov si, 0        ; set up array pointer
	menuDisplay_loop1:   
		mov al, menu[si]; get character
		;xor al, al
		cmp al, '$'   
		jz menuDisplay_exit  
		cmp al, 10
		je menuDisplay_loop2
		mov bh, 0   
		mov bl,0fh
		mov cx, 1   
		mov ah, 9   ; write character  on screen
		int 10H     
		inc si      ; point to next character/attribute
		add dl, 1   ; move two columns to the right
		mov ah, 2   
		int 10H    
		jmp menuDisplay_loop1    ; continue
	
	menuDisplay_exit:  ret
	
	menuDisplay_loop2:
		mov bh, 0   
		mov bl, 0fh
		mov cx, 1   
		mov ah, 0Ah   
		mov al, 10
		int 12H     
		inc si     
		add dh, 1   
		mov dl,0
		mov ah, 2   
		int 10H     
		jmp menuDisplay_loop1    ; continue

menuDisplay endp

displayScore proc near
	
	call gotoxy
	lea dx, Score
	mov ah, 09h
	int 21h
	
	mov al, score_num
	mov hundreds_score, al
	
	mov ax, 0  				
	mov al, hundreds_score			
	mov bl, 100
	div bl
	
	mov hundreds_score, al			
	add hundreds_score, '0'			
	
	mov tens_score, ah			
	
	mov ax, 0  				
	mov al, tens_score			
	mov bl, 10
	div bl
	
	mov tens_score, al			
	add tens_score, '0'			
	
	mov ones_score, ah			
	add ones_score, '0'
	
	cmp hundreds_score, '0'			
	jne @print_huns
	cmp tens_score, '0'			
	jne @print_tens
	jmp @print_ones			

	@print_huns:
		mov dl, hundreds_score			;print hundred's digit
		mov ah, 02H
		int 21H
	
	@print_tens:
		mov dl, tens_score			;print ten'ss digit
		mov ah, 02H
		int 21H
	
	@print_ones:
		mov dl, ones_score			;print one's digit
		mov ah, 02H
		int 21H
	ret
	
displayScore endp


playGame    proc    far 
    call    drawBricks 
	call 	drawBuffle
	
	playGame_loop1:
		mov ah, 06h
		mov dl, 0FFh
		int 21h
		jz	playGame_loop1
		
	play_loop: 
        mov     cl, delayTime 
        call    delay 
 
        call    hitWall 
        cmp     ax, 2 
        jz      playGame_quit 
        cmp     ax, 1 
        jz      playGame_skip1 
 
        call    hitBrick 
		jmp 	playGame_skip1

	playGame_quit:
		xor 	bx, bx
		mov 	bx, 1
		jmp     quit
		
	playGame_skip1: 
        call    moveBall 
		
        mov     ax, counter             ; finished all 
        test    ax, ax 
		mov 	bx, 2
        jz      quit 
 
        mov     ah, 11h 
        int     16h 
        jz      play_loop 
 
        mov     ah, 07h         ; get keyboard input 
        int     21h 
        cmp     al, 00 
        jnz     playGame_playGame_skip4 
        int     21h
		
	playGame_playGame_skip4: 
        cmp     al, 'K' 
        jz      left 
        cmp     al, 'M' 
        jz      right 
        cmp     al, 'q' 
        jz      quit 
        cmp     al, 27 
        jz      quit 
        jmp     playGame_skip5 
		
	left: 
        xor     ax, ax 
        call    drawBuffle 
 
        mov     ax, buffle 
        cmp     ax, 16 
        jle     left_edge 
        sub     ax, 16 
        jmp     playGame_skip3 
	
	left_edge: 
        mov     ax, 0 
		
	playGame_skip3: 
        mov     buffle, ax 
 
        mov     ax, 15 
        call    drawBuffle 
        jmp     playGame_skip5 
		
	right: 
        xor     ax, ax 
        call    drawBuffle 
 
        mov     ax, buffle 
        mov     cx, 320 
        sub     cx, buf_len 
        cmp     ax, cx 
        jge     right_edge 
        add     ax, 16 
        jmp     playGame_skip4 
	
	right_edge: 
        mov     ax, 320 
        sub     ax, buf_len 
	
	playGame_skip4: 
        mov     buffle, ax 
 
        mov     ax, 15 
        call    drawBuffle 
		
	playGame_skip5: 
        jmp     play_loop 
		
	quit:		
        ret 
playGame    endp 

scan_this	proc near
		mov ah, 01h
		int 21h
		ret
scan_this 	endp

scan_name proc near
	xor bx,bx
	call scan_this   	;scan each letter input by user
	mov name1, al
	call scan_this
	mov name2, al
	call scan_this
	mov name3, al
	call scan_this
	mov name4, al
	call scan_this
	mov name5, al
	ret
scan_name endp

new_line proc near
	mov dl, 10
	mov ah, 02h
	int 21h
	ret
new_line endp

print_char proc near
		mov dl, bl
		mov ah, 02h
		int 21h
		ret
print_char endp

print_name proc near
	mov bl, name1
	call print_char
	mov bl, name2
	call print_char
	mov bl, name3
	call print_char
	mov bl, name4
	call print_char
	mov bl, name5
	call print_char
	ret
print_name endp


.startup
    mov     ax, @data 
    mov     ds, ax 
		
	@main_menu:
		mov ax, 3
		int 10h
		
		mov ax, 3       ; 80x25 color
		int 10H          
		mov ah, 2       
		mov bh, 0       
		mov dh, row1        
		mov dl, col1     
		int 10H         
		lea bp, brick_block		; point to first attribute array
		call far ptr menuDisplay   ; display first line of video text
		
		;scan user's choice
		mov ah, 01h
		int 21h
		sub al, '0'
		mov choice, al
		
		cmp al, 1
		je level1
		cmp al, 2
		je level2
		cmp al, 3
		je level3
		cmp al, 4
		je @jump11
		cmp al, 5
		;call displayFile 
		je @jump1
		

		cmp al, 6
		mov     ax, 4c00h       ;call dos to exit 
		int     21h 
		
	level1:
		mov al, addScore1
		mov addScore, al
        mov     ax, 0a000h 
        mov     es, ax 
 
        mov     ax, 0013h 
        int     10h 
		
		cld
		
		mov ax, 1
		mov step_x, ax
		mov ax, -1
		mov step_y, ax
		xor ax, ax
		jmp @goPlay

	@jump1:
		jmp @jump2
	@jump11:
		jmp @jump22
		
	level2:
		mov al, addScore2
		mov addScore, al
		mov     ax, 0a000h 
        mov     es, ax 
 
        mov     ax, 0013h 
        int     10h 
		
		cld
		
		mov ax, 2
		mov step_x, ax
		mov ax, -2
		mov step_y, ax
		xor ax, ax
		jmp @goPlay
	
	level3:
		mov al, addScore3
		mov addScore, al
		mov     ax, 0a000h 
        mov     es, ax 
 
        mov     ax, 0013h 
        int     10h 
		
		cld
		
		mov ax, 3
		mov step_x, ax
		mov ax, -3
		mov step_y, ax
		xor ax, ax
		jmp @goPlay
	
	@goPlay:
		mov score_num,0
		mov x, 75
		mov y, 23
		call gotoxy
		xor ax, ax
		call print_name
		mov x, 0
		mov y, 23
		call displayScore
        call playGame 

		cmp ctr, 50
		jne @gameOver
		jmp @you_win

	@jump2:
		jmp @temp1
	@jump22:
		jmp @temp2
	@gameOver:				
		
		mov ah, 1          ;make cursor disappear
		mov cx, 2020h
		int 10h
		    
		mov ax, 2   ;reset video mode
		int 10h
  
		xor ax, ax
		xor bh, bh
		xor dx, dx
		 
		mov ax, 600h	 ;clear screen	
		mov bh, 7
		xor cx,cx
		mov dx, 184Fh
		int 10h
		jmp @thanksmessage
	
	@you_win:				
		
		mov ah, 1       ;Make cursor disappear
		mov cx, 2020h
		int 10h
			 
		mov ax, 3       ;reset video mode
		int 10h
  
		xor ax, ax
		xor bh, bh
		xor dx, dx
		 
		mov ax, 600h		 ;clear screen
		mov bh, 7
		xor cx,cx
		mov dx, 184Fh
		int 10h
		lea dx, congrats
		mov ah, 09h
		int 21h
		jmp @thanksmessage
	@instructions:
	    ;mov ax, 3       
		;int 10H           
		mov ah, 1          ;make cursor disappear
		mov cx, 2020h
		int 10h
		    
		mov ax, 2   ;reset video mode
		int 10h
  
		xor ax, ax
		xor bh, bh
		xor dx, dx
		 
		mov ax, 600h	 ;clear screen	
		mov bh, 7
		xor cx,cx
		mov dx, 184Fh
		int 10h
		lea dx, instructions
		mov ah, 09h
		int 21h    
		
		backMenu2:
		mov ah, 06h
		mov dl, 0FFh
		int 21h
		jz	backMenu2
		jmp @main_menu

		
	@highScore:
	    mov ah, 1
		mov cx, 2020h
		int 10h	
		
		mov ax, 2   ;reset video mode
		int 10h
  
		xor ax, ax
		xor bh, bh
		xor dx, dx
		 
		mov ax, 600h	 ;clear screen	
		mov bh, 7
		xor cx,cx
		mov dx, 184Fh
		int 10h
		
		lea dx, scores
		mov ah, 09h
		int 21h
		
		open:
			mov ah, 3dh
			mov al, 00
			lea dx, infile
			int 21h
			mov ch, 1
			jc  displayerror
			mov inhandle, ax
		
		read:
			mov ax, 3f00h
			mov bx, inhandle
			mov cx, 512
			mov dx, offset newtext
			int 21h
			jc  displayerror
			mov bytesread, ax
		
		convertletters:
			mov ah, 40h				
			mov bx, 1				
			mov cx, bytesread		

			mov temp2, cx
			lea si, newtext
		
		loopagain:
			cmp temp2, 0
			jg countletters
			jmp displaycontent
		
		countletters:
			mov ch, [si]
			xor ch, 20h
			
		displaycontent:
				mov cx, bytesread
				mov dx, offset newtext
				int 21h
				jc  displayerror

		closeinfile:
			mov ah, 3eh
			mov bx, inhandle
			int 21h		
			jc  displayerror
		
		backMenu1:
		mov ah, 06h
		mov dl, 0FFh
		int 21h
		jz	backMenu1
		jmp @main_menu

	@temp1:
		jmp @highScore
		
	@temp2:
		jmp @instructions	
	@thanksmessage:
		mov ax, 3      ;Enter name of player
		int 10h
		mov ah, 02h			
		mov bh, 0
		
		lea dx, gameOver
		mov ah, 09h
		int 21h
		
		lea dx, finalScore
		mov ah, 09h
		int 21h
	
		mov al, score_num
		mov hundreds_score, al
	
		mov ax, 0  				
		mov al, hundreds_score			
		mov bl, 100
		div bl
	
		mov hundreds_score, al			
		add hundreds_score, '0'			
		
		mov tens_score, ah			
		
	    mov ax, 0  				
		mov al, tens_score			
		mov bl, 10
		div bl
	
		mov tens_score, al			
		add tens_score, '0'			
	
		mov ones_score, ah			
		add ones_score, '0'
		
		cmp hundreds_score, '0'			
		jne @print_hun
		cmp tens_score, '0'			
		jne @print_ten
		jmp @print_one			
	
	@print_hun:
		mov dl, hundreds_score			
		mov ah, 02H
		int 21H
	
	@print_ten:
		mov dl, tens_score			
		mov ah, 02H
		int 21H
	
	@print_one:
		mov dl, ones_score			
		mov ah, 02H
		int 21H
		call new_line
		
	lea dx, nameofPlayer
	mov ah, 09h
	int 21h
	xor bx, bx
		
	call scan_name
		
	@print_file:
		mov dx, offset fileName     
		xor cx,cx       
		mov ah,6Ch      
		mov bx, 3
		mov dx, 12h
		int 21h         
		
		mov dx,offset fileName 	
		mov al,2 		
		mov ah,3Dh 		
		int 21h 		
		
		mov fileHandler,ax 		; save to file handler
		mov bx, fileHandler
		xor cx, cx
		xor dx, dx
		mov ah, 42h
		mov al, 02h
		int 21h		

		mov dx,offset name1 	
		mov bx,fileHandler 		
		mov cx,6 		
		mov ah,40h 		; write to file
		int 21h 		
		
		mov dx,offset spaces 	
		mov bx,fileHandler 		
		mov cx,11 		
		mov ah,40h 		
		int 21h 		
		
		mov dx,offset hundreds_score 	
		mov bx,fileHandler 		
		mov cx,1		
		mov ah,40h 		
		int 21h 		
		
		mov dx,offset tens_score 	
		mov bx,fileHandler 		
		mov cx,1 		
		mov ah,40h 		
		int 21h 		
		
		mov dx,offset ones_score 	
		mov bx,fileHandler 		
		mov cx,1 		
		mov ah,40h 		
		int 21h 		
		
		mov dx,offset nextLine 	
		mov bx,fileHandler 		
		mov cx,2		
		mov ah,40h 		
		int 21h 		
		
		mov bx,fileHandler 		
		mov ah,3Eh 		
		int 21h 		
		
		jmp @quit
			
	start_loop:
		mov ah, 06h
		mov dl, 0FFh
		int 21h
		jz	start_loop
		jmp @main_menu
	
	@quit: 
		mov     ax, 4c00h       ;call dos to exit 
		int     21h 
	
	displayerror:
		mov ah, 09h
		mov dx, offset errorg 					
		int 21h
		jmp @quit	
.exit
end

