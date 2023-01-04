def is_number(s):
  """ Check if is numeric

    Arguments:
      s (str): String to check.

    Returns:
      bool: True if s is numeric else False.
  """
  try:
    float(s)
    return True
  except ValueError:
    pass

  try:
    import unicodedata
    unicodedata.numeric(s)
    return True
  except (TypeError, ValueError):
    pass
  return False

print(is_number(3))
print(is_number('3'))
print(is_number('a'))