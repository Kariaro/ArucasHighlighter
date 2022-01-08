/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package me.hardcoded.arucas.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import me.hardcoded.arucas.psi.ArucasTypes;
import com.intellij.psi.TokenType;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>Arucas.flex</tt>
 */
class ArucasLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int STRING_DOUBLE = 2;
  public static final int STRING_SINGLE = 4;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2, 2
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [8, 6, 7]
   * Total runtime size is 1040 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[ZZ_CMAP_Y[ZZ_CMAP_Z[ch>>13]|((ch>>7)&0x3f)]|(ch&0x7f)];
  }

  /* The ZZ_CMAP_Z table has 136 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\207\100");

  /* The ZZ_CMAP_Y table has 128 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\177\200");

  /* The ZZ_CMAP_A table has 256 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\23\1\22\1\0\1\23\1\21\22\0\1\23\1\34\1\43\3\0\1\42\1\44\2\35\1\31"+
    "\1\30\1\35\1\27\1\26\1\32\12\25\2\35\1\40\1\36\1\37\2\0\32\24\1\35\1\45\1"+
    "\35\1\33\1\24\1\0\1\10\1\24\1\11\1\24\1\3\1\2\1\24\1\12\1\1\2\24\1\4\1\24"+
    "\1\17\1\6\2\24\1\7\1\5\1\14\1\16\1\20\1\13\1\24\1\15\1\24\1\35\1\41\1\35\202"+
    "\0");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\3\0\1\1\12\2\1\3\1\4\1\5\5\6\1\5"+
    "\2\1\1\7\1\10\1\11\1\12\3\11\1\13\13\2"+
    "\2\0\1\3\1\11\1\13\6\2\1\4\1\0\2\3"+
    "\1\0\2\3\4\2\4\0\1\3\1\2";

  private static int [] zzUnpackAction() {
    int [] result = new int[72];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\46\0\114\0\162\0\230\0\276\0\344\0\u010a"+
    "\0\u0130\0\u0156\0\u017c\0\u01a2\0\u01c8\0\u01ee\0\u0214\0\u023a"+
    "\0\162\0\u0260\0\u0286\0\162\0\u02ac\0\u02d2\0\u02d2\0\u02f8"+
    "\0\u031e\0\162\0\162\0\u0344\0\162\0\u036a\0\u0390\0\u03b6"+
    "\0\u010a\0\u03dc\0\u0402\0\u0428\0\u044e\0\u0474\0\u049a\0\u04c0"+
    "\0\u04e6\0\u050c\0\u0532\0\u0558\0\u057e\0\u05a4\0\u05ca\0\162"+
    "\0\u05f0\0\u0616\0\u063c\0\u0662\0\u0688\0\u06ae\0\u06d4\0\u057e"+
    "\0\u06fa\0\u0720\0\u0746\0\u076c\0\u0792\0\162\0\u07b8\0\u07de"+
    "\0\u0804\0\u082a\0\u0850\0\u0746\0\u0876\0\u089c\0\u089c\0\u08c2";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[72];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\4\1\5\1\6\1\7\1\10\1\11\3\10\1\12"+
    "\1\10\1\13\1\14\2\10\1\15\1\16\3\17\1\10"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\1\24\1\26"+
    "\1\21\3\27\1\30\1\31\1\32\1\33\1\4\21\34"+
    "\2\4\20\34\1\35\1\34\1\36\21\37\2\4\21\37"+
    "\1\35\1\40\47\0\1\10\1\41\16\10\3\0\2\10"+
    "\21\0\5\10\1\42\7\10\1\43\2\10\3\0\2\10"+
    "\21\0\3\10\1\44\14\10\3\0\2\10\21\0\20\10"+
    "\3\0\2\10\21\0\12\10\1\45\1\46\4\10\3\0"+
    "\2\10\21\0\3\10\1\47\3\10\1\50\10\10\3\0"+
    "\2\10\21\0\11\10\1\51\6\10\3\0\2\10\21\0"+
    "\6\10\1\52\11\10\3\0\2\10\21\0\2\10\1\53"+
    "\15\10\3\0\2\10\21\0\7\10\1\54\10\10\3\0"+
    "\2\10\41\0\3\17\47\0\1\20\1\55\46\0\1\24"+
    "\7\0\1\21\36\0\1\24\46\0\1\56\1\57\51\0"+
    "\1\21\50\0\1\21\46\0\1\21\3\0\21\34\2\0"+
    "\20\34\1\0\1\34\10\0\1\60\4\0\1\60\2\0"+
    "\1\60\23\0\1\60\2\0\21\37\2\0\21\37\11\0"+
    "\1\60\4\0\1\60\2\0\1\60\24\0\1\60\2\0"+
    "\6\10\1\61\11\10\3\0\2\10\21\0\16\10\1\41"+
    "\1\10\3\0\2\10\21\0\4\10\1\62\13\10\3\0"+
    "\2\10\21\0\1\63\17\10\3\0\2\10\21\0\7\10"+
    "\1\64\10\10\3\0\2\10\21\0\7\10\1\65\10\10"+
    "\3\0\2\10\21\0\4\10\1\62\6\10\1\66\4\10"+
    "\3\0\2\10\21\0\1\67\17\10\3\0\2\10\21\0"+
    "\14\10\1\41\3\10\3\0\2\10\21\0\12\10\1\41"+
    "\5\10\3\0\2\10\21\0\6\10\1\41\11\10\3\0"+
    "\2\10\45\0\1\70\20\0\21\71\1\72\1\73\6\71"+
    "\1\74\14\71\21\57\1\75\1\76\23\57\1\0\2\10"+
    "\1\77\15\10\3\0\2\10\21\0\2\10\1\41\15\10"+
    "\3\0\2\10\21\0\13\10\1\66\4\10\3\0\2\10"+
    "\21\0\13\10\1\100\4\10\3\0\2\10\21\0\4\10"+
    "\1\101\13\10\3\0\2\10\21\0\10\10\1\102\7\10"+
    "\3\0\2\10\21\0\3\10\1\62\14\10\3\0\2\10"+
    "\20\0\21\71\1\72\1\73\6\71\1\103\14\71\22\104"+
    "\1\73\6\104\1\105\45\104\1\105\14\104\21\106\1\75"+
    "\1\76\6\106\1\74\1\107\13\106\22\0\1\76\24\0"+
    "\7\10\1\66\10\10\3\0\2\10\21\0\1\110\17\10"+
    "\3\0\2\10\21\0\4\10\1\41\13\10\3\0\2\10"+
    "\21\0\11\10\1\41\6\10\3\0\2\10\20\0\21\71"+
    "\1\72\1\73\6\71\1\103\1\107\13\71\31\104\1\105"+
    "\1\76\13\104\21\106\1\75\1\76\23\106\1\0\10\10"+
    "\1\41\7\10\3\0\2\10\20\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2280];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\3\0\1\11\14\1\1\11\2\1\1\11\5\1\2\11"+
    "\1\1\1\11\17\1\2\0\1\1\1\11\10\1\1\0"+
    "\2\1\1\0\1\1\1\11\4\1\4\0\2\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[72];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  ArucasLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      {@code false}, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position {@code pos} from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        zzDoEOF();
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { throw new Error("Illegal character <"+yytext()+">");
            } 
            // fall through
          case 12: break;
          case 2: 
            { return ArucasTypes.IDENTIFIER;
            } 
            // fall through
          case 13: break;
          case 3: 
            { return TokenType.WHITE_SPACE;
            } 
            // fall through
          case 14: break;
          case 4: 
            { return ArucasTypes.NUMBER;
            } 
            // fall through
          case 15: break;
          case 5: 
            { return ArucasTypes.SYNTAX;
            } 
            // fall through
          case 16: break;
          case 6: 
            { return ArucasTypes.OPERATOR;
            } 
            // fall through
          case 17: break;
          case 7: 
            { yybegin(STRING_DOUBLE);
            } 
            // fall through
          case 18: break;
          case 8: 
            { yybegin(STRING_SINGLE);
            } 
            // fall through
          case 19: break;
          case 9: 
            { 
            } 
            // fall through
          case 20: break;
          case 10: 
            { yybegin(YYINITIAL); return ArucasTypes.STRING;
            } 
            // fall through
          case 21: break;
          case 11: 
            { return ArucasTypes.KEYWORD;
            } 
            // fall through
          case 22: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
